package com.tutorin.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.tutorin.app.`object`.TutorObject
import com.tutorin.app.adapter.tutorAdapter
import kotlinx.android.synthetic.main.activity_tutor.*

class Tutors : AppCompatActivity(){
    private var listTutor: ArrayList<TutorObject> = arrayListOf()
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef: DatabaseReference = database.reference
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: tutorAdapter
    companion object {
        var TUTOR_NAME = ""
        var topicName = ""
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor)
        val subjectName = intent.getSerializableExtra(topicName)
        val slicedString = subjectName.toString().split("//").toTypedArray()
       // println("TEST" + subjectName)
       // println("nama pelajarannya adalah" + slicedString[0] + "dan" + slicedString[1])
        val topicname = slicedString[0]
        val subjectname = slicedString[1]
        onCreateComponent(listTutor)
        addTutor(listTutor, topicname, subjectname)
        showRecyclerView()




       // recycler_tutor.adapter = adapter
        //recycler_tutor.layoutManager = LinearLayoutManager(this)
        //recycler_tutor.setHasFixedSize(true)
    }
    private fun onCreateComponent(list: ArrayList<TutorObject>) {
        adapter = tutorAdapter(list)
    }
    private fun showRecyclerView(){
        recyclerView = findViewById(R.id.recycler_tutor)
        recyclerView.layoutManager =  LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.setOnItemClickCallback(object : tutorAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TutorObject) {
                println(data)
                val intent = Intent(this@Tutors, tutorProfile::class.java).apply {
                    putExtra(tutorProfile.tutorProfile, data)
                }
                startActivity(intent)
            }

        })
    }
    private fun addTutor(list: ArrayList<TutorObject>, topicName: String, subjectName : String): ArrayList<TutorObject> {
        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth!!.currentUser

        myRef.child("subject").child(topicName).child(subjectName).child("tutor")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                }
                override fun onDataChange(snapshot: DataSnapshot) {
                    list.clear()
                    for (tutor in snapshot.children) {
                        val tutorProfile = TutorObject()
                        tutorProfile.nama = tutor.child("nama").value.toString()
                        tutorProfile.subject = tutor.child("subject").value.toString()
                        tutorProfile.description = tutor.child("description").value.toString()
                        tutorProfile.emailtutor = tutor.child("emailtutor").value.toString()
                        tutorProfile.pendidikan = tutor.child("pendidikan").value.toString()
                        tutorProfile.tariff = tutor.child("tariff").value.toString()
                        tutorProfile.linkedin = tutor.child("linkedin").value.toString()
                        tutorProfile.notelp = tutor.child("notelp").value.toString()
                        tutorProfile.whatsapp = tutor.child("whatsapp").value.toString()
                        list.add(tutorProfile)
                    }
                    //println(list[0].subjectDesc)
                    adapter.notifyDataSetChanged()
                }
            })
        return list
    }

}

