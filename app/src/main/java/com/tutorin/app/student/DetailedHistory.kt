package com.tutorin.app.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorin.app.R
import com.tutorin.app.`object`.dataHistory
import com.tutorin.app.adapter.detailedHistoryAdapter

class DetailedHistory : AppCompatActivity() {
    private lateinit var rvOrderHistory: RecyclerView
    private var list: ArrayList<dataHistory> = arrayListOf()
    companion object {
        const val orderDetail = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_history)

        val detailInfo = intent.getSerializableExtra(orderDetail) as dataHistory
        rvOrderHistory = findViewById(R.id.rv_detailedHistory)
        list.add(detailInfo)
        showRecyclerList()

    }
    private fun showRecyclerList() {
        rvOrderHistory.layoutManager = LinearLayoutManager(this)
        val listOrder = detailedHistoryAdapter(list)
        rvOrderHistory.adapter = listOrder
    }
}
