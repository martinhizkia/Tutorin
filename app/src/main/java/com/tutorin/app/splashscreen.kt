package com.tutorin.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.postDelayed
import kotlinx.coroutines.delay

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@splashscreen, Home::class.java)
            startActivity(intent)
        }, 3000)
    }
}