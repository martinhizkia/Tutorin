package com.tutorin.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.tutorin.app.`object`.*
import kotlinx.android.synthetic.main.activity_home.*
import org.w3c.dom.Text

class Home : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef: DatabaseReference = database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var nama:TextView = findViewById(R.id.userName)
        var email:TextView = findViewById(R.id.userEmail)
        var phone:TextView = findViewById(R.id.userPhone)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth!!.currentUser

        btnLogOut.setOnClickListener{
            auth.signOut()
            Intent(this@Home, Login::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

    }
}


