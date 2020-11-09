package com.tutorin.app.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tutorin.app.*
import com.tutorin.app.`object`.dataHistory

class historyAdapter(private val listHistory: ArrayList<dataHistory>): RecyclerView.Adapter<historyAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_subjectName)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_subject)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_history, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val history = listHistory[position]
        Glide.with(holder.itemView.context)
            .load(history.subjectPhoto)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = history.subjectName
        holder.tvDetail.text = history.orderDetail
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }
}