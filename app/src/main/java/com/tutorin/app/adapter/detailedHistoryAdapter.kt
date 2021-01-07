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

class detailedHistoryAdapter(private val detailedHistory: ArrayList<dataHistory>): RecyclerView.Adapter<detailedHistoryAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvOrderID: TextView = itemView.findViewById(R.id.detOrderID)
        var tvSubjectName: TextView = itemView.findViewById(R.id.detSubjName)
        var tvOrderDate: TextView = itemView.findViewById(R.id.detOrderDate)
        var tvTariff: TextView = itemView.findViewById(R.id.detOrderTariff)
        var tvTutorName: TextView = itemView.findViewById(R.id.detTutorName)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_detailed_history, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val detailed = detailedHistory[position]

        holder.tvOrderID.text = detailed.orderID
        holder.tvSubjectName.text = detailed.orderSubject
        holder.tvOrderDate.text = detailed.orderDate
        holder.tvTariff.text = detailed.tariff.toString()
        holder.tvTutorName.text = detailed.tutorName
    }

    override fun getItemCount(): Int {
        return detailedHistory.size
    }

}