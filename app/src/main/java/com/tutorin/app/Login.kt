package com.tutorin.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tutorin.app.`object`.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener{
            val email: String = etEmail.text.toString().trim()
            val password: String = etPassword.text.toString().trim()

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
            loginUser(email, password)
        }

        btnRegister.setOnClickListener{
            Intent( this@Login, Register::class.java).also{
                startActivity(it)
            }
        }
        btnForgotPassword.setOnClickListener{
            Intent( this@Login, ForgotPassword::class.java).also{
                startActivity(it)
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Intent(this@Login, Home::class.java).also {
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
            Intent(this@Login, Home::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}
