package com.tutorin.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutorin.app.`object`.dataHome
import com.tutorin.app.adapter.tutorAdapter
import kotlinx.android.synthetic.main.activity_tutor.*

class Tutors : AppCompatActivity(), tutorAdapter.OnItemClickListener {
    private val tutorList = generateDummyTutor(500)
    private val adapter = tutorAdapter(tutorList, this)

    companion object {
        const val TUTOR_PROFILE = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor)
        recycler_tutor.adapter = adapter
        recycler_tutor.layoutManager = LinearLayoutManager(this)
        recycler_tutor.setHasFixedSize(true )
    }

    override fun onItemClick(item: tutorDataExample, position: Int) {
        val intent = Intent(this, tutorProfile::class.java)
            .putExtra(TUTOR_PROFILE,dataHome("","", item.text1))
        startActivity(intent)

    }

    private fun generateDummyTutor(size: Int): List<tutorDataExample>{
        val list = ArrayList<tutorDataExample>()
        for (i in 0 until size) {
            val drawable = when (i % 3){
                0 -> R.drawable.ic_business
                1 -> R.drawable.ic_engineering
                else -> R.drawable.ic_home
            }
            val item = tutorDataExample(drawable, "$i")
            list += item
        }
        return list
    }
}