package com.tutorin.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorin.app.R
import com.tutorin.app.tutorDataExample
import kotlinx.android.synthetic.main.item_tutors.view.*

class tutorAdapter(private  val tutorList: List<tutorDataExample>) : RecyclerView.Adapter<tutorAdapter.tutorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tutorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tutors,
            parent, false)
        return tutorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: tutorViewHolder, position: Int) {
        val currentItem = tutorList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
    }

    override fun getItemCount() = tutorList.size

    class tutorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.tutor_image
        val textView1: TextView = itemView.tutor_list_name

    }
}