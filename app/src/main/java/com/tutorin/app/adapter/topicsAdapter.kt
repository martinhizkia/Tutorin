package com.tutorin.app.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.tutorin.app.R
import com.tutorin.app.Tutors
import com.tutorin.app.student.UpdateProfile
import kotlinx.android.synthetic.main.business_layout.view.*

class topicsAdapter(private val judulList: List<String>): RecyclerView.Adapter<topicsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.text_view
        init {
            itemView.setOnClickListener{
                val intent = Intent(itemView.context, Tutors::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.business_layout, parent, false )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = judulList[position]
        holder.textView.text = judulList[position]
    }

    override fun getItemCount() = judulList.size
}