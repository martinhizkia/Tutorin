package com.tutorin.app.student

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorin.app.R
import com.tutorin.app.`object`.dataHistory
import com.tutorin.app.adapter.detailedHistoryAdapter
import kotlinx.android.synthetic.main.detailed_history.*

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

        val email:String = "jonathan.sendiko@gmail.com"
        val subjectReport:String = "Report For Tutorin App"
        val bodyReport:String = "Report Message: "
        val subjectFeedback:String = "Feedback For Tutorin App"
        val bodyFeedback:String = "Feedback Message: "


        reportButton.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subjectReport)
            emailIntent.putExtra(Intent.EXTRA_TEXT, bodyReport)
            startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
        }

        feedbackButton.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subjectFeedback)
            emailIntent.putExtra(Intent.EXTRA_TEXT, bodyFeedback)
            startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
        }

    }
    private fun showRecyclerList() {
        rvOrderHistory.layoutManager = LinearLayoutManager(this)
        val listOrder = detailedHistoryAdapter(list)
        rvOrderHistory.adapter = listOrder
    }
}
