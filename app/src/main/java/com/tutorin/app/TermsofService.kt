package com.tutorin.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_privacy_policy.*

class TermsofService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termsof_service)
        webView.loadUrl("https://tutorin.flycricket.io/terms.html")
    }
}