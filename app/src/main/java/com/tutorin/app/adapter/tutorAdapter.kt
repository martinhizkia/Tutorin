package com.tutorin.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorin.app.R
import com.tutorin.app.`object`.TutorObject

class tutorAdapter(
    private val tutorObjectList: ArrayList<TutorObject>
): RecyclerView.Adapter<tutorAdapter.ListViewHolder>()
{
    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var recycleView: RecyclerView
    companion object {
        const val TUTOR_NAME = ""
    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: TutorObject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_tutors,
            parent, false)
        return ListViewHolder(itemView)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var imageView: TextView = itemView.findViewById(R.id.tutor_image)
        var textView1: TextView = itemView.findViewById(R.id.tutor_list_name)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = tutorObjectList[position]
        holder.textView1.text = currentItem.nama
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(tutorObjectList[holder.adapterPosition])
        }
        //holder.imageView.setImageResource(currentItem.imageResource)
    }


    override fun getItemCount() = tutorObjectList.size


    }
