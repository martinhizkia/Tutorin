package com.tutorin.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutorin.app.adapter.tutorAdapter
import kotlinx.android.synthetic.main.activity_tutor.*

class Tutors : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor)

        val tutorExample = generateDummyTutor(500)
        recycler_tutor.adapter = tutorAdapter(tutorExample)
        recycler_tutor.layoutManager = LinearLayoutManager(this)
        recycler_tutor.setHasFixedSize(true )
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