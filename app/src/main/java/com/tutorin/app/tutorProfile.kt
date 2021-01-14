package com.tutorin.app

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.TextView
import com.tutorin.app.`object`.TutorObject
import com.tutorin.app.`object`.dataHome
import kotlinx.android.synthetic.main.activity_tutor_profile.*
import org.w3c.dom.Text

class tutorProfile : AppCompatActivity() {

    companion object {
        var tutorProfile = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_profile)
        val tutorProfile = intent.getSerializableExtra(tutorProfile) as TutorObject
        //val getTutorName = intent.getSerializableExtra(Tutors.TUTOR_PROFILE)
        val tutorName: TextView = findViewById(R.id.tutor_name_profile)
        val tutorEmail: TextView = findViewById(R.id.tutor_email)
        val tutorDesc: TextView = findViewById(R.id.tutor_description)
        val tutorSubject:  TextView = findViewById(R.id.tutor_topic)
        val tutorTariff: TextView =findViewById(R.id.tutor_fee)
        val tutorUniv: TextView= findViewById(R.id.tutor_university)
        tutorName.text = tutorProfile.nama
        tutorEmail.text = tutorProfile.emailtutor
        tutorDesc.text = tutorProfile.description
        tutorSubject.text = tutorProfile.subject
        tutorTariff.text = tutorProfile.tariff
        tutorUniv.text = tutorProfile.pendidikan

        buttonLinkedin.setOnClickListener{
            val url = tutorProfile.linkedin
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(i)
        }

        btnAppointment.setOnClickListener{
            val intent = Intent(this@tutorProfile, BookingscreenActivity::class.java).apply {
                putExtra(BookingscreenActivity.tutorBooking, tutorProfile )
            }
            startActivity(intent)
        }
        buttonLinkedin.setOnClickListener{
            val url = tutorProfile.whatsapp
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(i)
        }
    }
}