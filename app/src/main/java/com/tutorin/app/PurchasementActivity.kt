package com.tutorin.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class PurchasementActivity : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchasement)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@PurchasementActivity, Home::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

}