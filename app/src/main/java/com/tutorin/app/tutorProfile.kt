package com.tutorin.app

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.TextView
import com.tutorin.app.`object`.dataHome

class tutorProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_profile)
        val getTutorName = intent.getSerializableExtra(Tutors.TUTOR_PROFILE) as dataHome
        val tutorName: TextView = findViewById(R.id.tutor_name_profile)
        tutorName.text = getTutorName.tutorName
    }
}