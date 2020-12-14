package com.tutorin.app.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.tutorin.app.R
import kotlinx.android.synthetic.main.activity_update_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import java.io.ByteArrayOutputStream


class UpdateProfile : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var imageUri: Uri

    companion object{
        val REQUEST_CAMERA = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

    }

    
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        if (user != null) {
            if(user.photoUrl != null) {
            Picasso.get().load(user.photoUrl).into(ivProfile)
            }
            else{
            Picasso.get().load("https://picsum.photos/200").into(ivProfile)
            }
            etName.setText(user.displayName)
            etEmail.setText(user.email)
            if(user.isEmailVerified){
                ic_verified.visibility = View.VISIBLE
            }
            else{
                ic_unverified.visibility = View.VISIBLE
            }
            if(user.phoneNumber.isNullOrEmpty()){
                etPhone.setText("Masukkan nomor telpon anda!")
            }
            else{
                etPhone.setText(user.phoneNumber)
            }
        }

        ivProfile.setOnClickListener {
            intentCamera()
        }
        btnUpdate.setOnClickListener {
            val image = when{
                ::imageUri.isInitialized -> imageUri
                user?.photoUrl == null -> Uri.parse("https://picsum.photos/200")
                else -> user.photoUrl
            }
            val name = etName.text.toString().trim()
            if(name.isEmpty()){
                etName.error = "Masukkan nama anda!"
                etName.requestFocus()
                return@setOnClickListener
            }
            UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .setPhotoUri(image)
                .build().also {
                    user?.updateProfile(it)?.addOnCompleteListener {
                        if(it.isSuccessful){
                            Toast.makeText(this, "Profile telah diperbaharui", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }
    }

    private fun intentCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{ intent ->
            intent.resolveActivity(packageManager).also {
                startActivityForResult(intent, REQUEST_CAMERA)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CAMERA) {
            val imgBitmap = data?.extras?.get("data") as Bitmap
            uploadImage(imgBitmap)
        }
    }

    private fun uploadImage(imgBitmap: Bitmap) {
        val baos = ByteArrayOutputStream()
        val ref = FirebaseStorage.getInstance().reference.child("img/${FirebaseAuth.getInstance().currentUser?.uid}")
        imgBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()
        ref.putBytes(image).addOnCompleteListener {
            if (it.isSuccessful){
                ref.downloadUrl.addOnCompleteListener {
                    it.result?.let {
                        imageUri = it
                        ivProfile.setImageBitmap(imgBitmap)
                    }
                }
            }
        }
    }


}
