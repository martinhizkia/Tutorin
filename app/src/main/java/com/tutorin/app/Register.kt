package com.tutorin.app

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.tutorin.app.`object`.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import org.w3c.dom.Document

class Register : AppCompatActivity(){
    private lateinit var auth: FirebaseAuth
    private lateinit var store: FirebaseFirestore
    private lateinit var database: FirebaseDatabase
    private lateinit var spinner: Spinner
    var userID: String = " "
    //val choices = resources.getStringArray(R.array.Tutoratobukan)
    val choices = arrayOf<String>("Pelajar", "Tutor")
    var registeredUser: User = User()
    var registeredFullName = " "
    var registeredEmail = " "
    var registeredPhoneNumber = " "
    var registeredTutorORNot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        spinner = findViewById<Spinner>(R.id.spinnerTutor)
        val arrayAdapter = ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, choices)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                registeredTutorORNot = position != 0
            }
        }




        btnRegister2.setOnClickListener{
            val email: String = etEmail2.text.toString().trim()
            val password: String = etPassword2.text.toString().trim()
            registeredFullName = etName2.text.toString().trim()
            registeredEmail = etEmail2.text.toString().trim()
            registeredPhoneNumber = etPhoneNumber2.text.toString().trim()

            if (email.isEmpty()){
                etEmail.error = "Email is Needed"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length <8 ){
                etPassword.error = "Password must has minimum 8 characters"
                etPassword.requestFocus()
                return@setOnClickListener
            }
                    registerUser(email, password)
        }


        btnLogin2.setOnClickListener{
            Intent( this@Register, Login::class.java).also{
                startActivity(it)
            }
        }
    }
    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    registeredUser.fullName = registeredFullName
                    registeredUser.userEmail = registeredEmail
                    registeredUser.tutorOrNot = registeredTutorORNot
                    registeredUser.phoneNum = registeredPhoneNumber

                    Intent(this@Register, Home::class.java).also{
                        userID = auth.currentUser!!.uid
                        FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().currentUser!!.uid)
                            .setValue(registeredUser).addOnCompleteListener(OnCompleteListener {
                                if(it.isSuccessful){
                                    Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                                }
                            })

                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else{
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    override fun onStart() {
        super.onStart()
        if(auth.currentUser != null){
            Intent(this@Register, Home::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}