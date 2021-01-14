package com.tutorin.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tutorin.app.`object`.TutorObject
import kotlinx.android.synthetic.main.activity_bookingscreen.*
import kotlinx.android.synthetic.main.activity_tutor_profile.*

class BookingscreenActivity : AppCompatActivity() {

    companion object {
        var tutorBooking = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookingscreen)
        val tutorBooking = intent.getSerializableExtra(tutorBooking) as TutorObject
        val orderTopic: TextView = findViewById(R.id.booked_topics)
        val orderName: TextView = findViewById(R.id.tutor_name)
        val orderFee: TextView = findViewById(R.id.fee)
        val orderTotal: TextView = findViewById(R.id.Total_fee)

        orderTopic.text = tutorBooking.subject
        orderName.text = tutorBooking.nama
        orderFee.text = tutorBooking.tariff
        orderTotal.text = tutorBooking.tariff

        whatsApp.setOnClickListener{
            val url = tutorBooking.whatsapp
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(i)
        }

        btnBooking.setOnClickListener{
            val intent = Intent(this@BookingscreenActivity, PurchasementActivity::class.java)
            startActivity(intent)
        }
    }
}