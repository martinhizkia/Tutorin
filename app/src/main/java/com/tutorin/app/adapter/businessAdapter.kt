package com.tutorin.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorin.app.R
import kotlinx.android.synthetic.main.business_layout.view.*

class businessAdapter(private val judulList: List<String>): RecyclerView.Adapter<businessAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.text_view
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