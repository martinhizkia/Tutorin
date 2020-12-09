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
import android.net.Uri
import android.provider.MediaStore
import com.google.firebase.storage.FirebaseStorage


class UpdateProfile : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private var imageUri: Uri? = null
    private val pickImage = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

    }

    
    /*override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ivProfile.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            ivProfile.setImageURI(imageUri)
            uploadImage(imageUri)
        }
    }

    private fun uploadImage(imageUri: Uri?) {
        val baos = byteArrayOutputStream()
        val ref = FirebaseStorage.getInstance().reference.child("img/${FirebaseAuth.getInstance().currentUser?.uid}")
    }*/

}
