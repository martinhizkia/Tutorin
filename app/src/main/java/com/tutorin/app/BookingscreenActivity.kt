package com.tutorin.app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.tutorin.app.`object`.TutorObject
import com.tutorin.app.`object`.dataHistory
import kotlinx.android.synthetic.main.activity_bookingscreen.*
import kotlinx.android.synthetic.main.activity_tutor_profile.*
import java.text.SimpleDateFormat
import java.util.*

class BookingscreenActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = getInstance()
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef: DatabaseReference = database.reference
    companion object {
        var tutorBooking = ""
    }
    private var orderInfo = dataHistory()
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

        orderInfo.orderSubject = tutorBooking.subject
        orderInfo.tariff = tutorBooking.tariff
        orderInfo.tutorName = tutorBooking.nama


        whatsApp.setOnClickListener{
            val url = tutorBooking.whatsapp
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(i)
        }

        btnBooking.setOnClickListener{
            uploadMatch(orderInfo)
            val intent = Intent(this@BookingscreenActivity, PurchasementActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun uploadMatch(data: dataHistory){
        val currentUser = mAuth!!.currentUser
        val df = SimpleDateFormat("dd-MM-yyyy HH:mm")
        val dataobj= Date()
        val currentTime = df.format(dataobj)
        val tanggalOrder = currentTime.substringBefore(" ")
        val jamOrder = currentTime.substringAfter(" ")
        val dataRef = myRef.child("Users").child(currentUser!!.uid).child("orderHistory").child("$tanggalOrder$jamOrder")
        val idgenerator =  (11111..99999).random()

        dataRef.child("orderDate").setValue(tanggalOrder)
        dataRef.child("orderID").setValue(idgenerator)
        dataRef.child("orderSubject").setValue(data.orderSubject)
        dataRef.child("tariff").setValue("Rp"+data.tariff.toString())
        dataRef.child("tutorName").setValue(data.tutorName)
    }
}