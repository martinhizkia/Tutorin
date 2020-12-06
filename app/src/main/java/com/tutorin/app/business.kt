package com.tutorin.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutorin.app.adapter.businessAdapter
import kotlinx.android.synthetic.main.activity_business.*

class business : AppCompatActivity() {
    private var listJudul = mutableListOf<String>("Dasar Berbisnis", "Kewirausahawan", "Bisnis 1", "Bisnis 2", "Bisnis 3", "Bisnis 4")

    companion object{
        const val topicsName = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business)


        businessRecyclerView.adapter = businessAdapter(listJudul)
        businessRecyclerView.layoutManager = LinearLayoutManager(this)
        businessRecyclerView.setHasFixedSize(true)
    }
}