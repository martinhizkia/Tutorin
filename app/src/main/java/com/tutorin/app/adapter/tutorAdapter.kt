package com.tutorin.app.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorin.app.R
import com.tutorin.app.tutorDataExample
import kotlinx.android.synthetic.main.item_tutors.view.*

class tutorAdapter(
    private  val tutorList: List<tutorDataExample>,
    private  val listener: OnItemClickListener
) : RecyclerView.Adapter<tutorAdapter.tutorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tutorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tutors,
            parent, false)
        return tutorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: tutorViewHolder, position: Int) {
//        val currentItem = tutorList[position]
//        holder.imageView.setImageResource(currentItem.imageResource)
//        holder.textView1.text = currentItem.text1
        holder.initialize(tutorList.get(position), listener)

    }

    override fun getItemCount() = tutorList.size

    inner class tutorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.tutor_image
        val textView1: TextView = itemView.tutor_list_name

        fun initialize(item: tutorDataExample, action:OnItemClickListener){
            textView1.text = item.text1
            imageView.setImageResource(item.imageResource)

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition)
            }
        }

    }
    interface  OnItemClickListener {
        fun onItemClick( item: tutorDataExample, position: Int)
    }
}