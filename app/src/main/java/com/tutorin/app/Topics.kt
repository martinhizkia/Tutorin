package com.tutorin.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.tutorin.app.`object`.dataHome
import com.tutorin.app.`object`.topicsDescription
import com.tutorin.app.adapter.topicsAdapter
import com.tutorin.app.student.HomeFragment
import kotlinx.android.synthetic.main.activity_topics.*


class Topics : AppCompatActivity() {


    //private var listJudul = mutableListOf<String>("Dasar Berbisnis", "Kewirausahawan", "Bisnis 1", "Bisnis 2", "Bisnis 3", "Bisnis 4", "DDP")
    private var listsubject: ArrayList<topicsDescription> = arrayListOf()
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef: DatabaseReference = database.reference
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: topicsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topics)
        val ss = intent.getSerializableExtra(HomeFragment.TOPICS_NAME) as dataHome
        val subjectName: String = ""
        val topicsName: TextView = findViewById(R.id.topicsName)
        topicsName.text = ss.topicName
        var topicName = ss.topicName.toString().toLowerCase()
        println("SSnya adalah" + topicName)
        onCreateComponent()
        addSubject(listsubject, topicName)
        showRecyclerView(topicName)
    }
    private fun onCreateComponent(){
        adapter = topicsAdapter(listsubject)
    }
    private fun showRecyclerView(topicName:String){
        recyclerView = findViewById(R.id.businessRecyclerView)
        recyclerView.layoutManager =  LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter.setOnItemClickCallback(object : topicsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: topicsDescription) {
                println(data)
                val topsub = topicName + "//" + data.subjectName
                val intent = Intent(this@Topics, Tutors::class.java).apply {
                    putExtra(Tutors.topicName, topsub)
                }
                startActivity(intent)
            }

        })
    }


    private fun addSubject(list: ArrayList<topicsDescription>, topicName: String): ArrayList<topicsDescription> {
        myRef.child("subject").child(topicName)
            .addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (subject in snapshot.children) {
                    val topicList = topicsDescription()
                    topicList.subjectName = subject.child("subjectname").value.toString()
                    topicList.subjectDesc = subject.child("subjectdesc").value.toString()
                    list.add(topicList)
                }
                println(list[0].subjectDesc)
                adapter.notifyDataSetChanged()
            }
        })
        return list
    }
}


