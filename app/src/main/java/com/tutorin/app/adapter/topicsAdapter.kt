package com.tutorin.app.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorin.app.R
import com.tutorin.app.Tutors
import com.tutorin.app.`object`.dataHome
import com.tutorin.app.`object`.topicsDescription
import kotlinx.android.synthetic.main.business_layout.view.*

class topicsAdapter(private val judulList: ArrayList<topicsDescription>): RecyclerView.Adapter<topicsAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var recycleView: RecyclerView
    companion object {
        const val TUTOR_NAME = ""
    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: topicsDescription)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.business_layout, parent, false )
        return ListViewHolder(itemView)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var subjName: TextView = itemView.findViewById(R.id.text_view)
        var subjDesc: TextView = itemView.findViewById(R.id.desc_textview)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = judulList[position]
        holder.subjName.text = currentItem.subjectName
        holder.subjDesc.text = currentItem.subjectDesc
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(judulList[holder.adapterPosition])
            val position = holder.adapterPosition.toString()
        }
    }

    override fun getItemCount() = judulList.size
}