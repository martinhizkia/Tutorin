package com.tutorin.app.adapter
import android.graphics.Color
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
import org.w3c.dom.Text

class historyAdapter(private val listHistory: ArrayList<dataHistory>): RecyclerView.Adapter<historyAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvOrderID: TextView = itemView.findViewById(R.id.tv_orderID)
        var tvSubjectName: TextView = itemView.findViewById(R.id.tv_subjectName)
        var tvOrderDate: TextView = itemView.findViewById(R.id.tv_orderDate)
        var tvTariff: TextView = itemView.findViewById(R.id.tvTariff)
        var tvTutorName: TextView = itemView.findViewById(R.id.tv_tutorName)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_history, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val history = listHistory[position]

        holder.tvOrderID.text = history.orderID
        holder.tvSubjectName.text = history.orderSubject
        holder.tvOrderDate.text = history.orderDate
        holder.tvTariff.text = history.tariff.toString()
        holder.tvTutorName.text = history.tutorName
        holder.tvTariff.setTextColor(Color.WHITE)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHistory[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: dataHistory)
    }
}
