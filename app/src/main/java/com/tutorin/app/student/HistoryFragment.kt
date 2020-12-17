package com.tutorin.app.student

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.tutorin.app.Home
import com.tutorin.app.R
import com.tutorin.app.`object`.dataHistory
import com.tutorin.app.`object`.exampleData
import com.tutorin.app.adapter.historyAdapter
import kotlinx.android.synthetic.main.detailed_history.*
import kotlinx.android.synthetic.main.detailed_history.view.*
import java.util.zip.Inflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class HistoryFragment : Fragment() {
    private var list: ArrayList<dataHistory> = arrayListOf()
    private lateinit var root: View
    private lateinit var adapter: historyAdapter
    private lateinit var recyclerView: RecyclerView
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef: DatabaseReference = database.reference
    companion object {
        fun newInstance(): HistoryFragment = HistoryFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_history, container, false)
        setHasOptionsMenu(true)
        onCreateComponent()
        addOrderHistory(list)
        println(list)
        showRecycleList()
        return root
    }

    private fun showRecycleList(){
        recyclerView = root.findViewById(R.id.rv_history)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        adapter.setOnItemClickCallback(
            object: historyAdapter.OnItemClickCallback{
                override fun onItemClicked(data: dataHistory) {
                    val movetoOrderDetailed = Intent(activity, DetailedHistory::class.java).apply{
                        putExtra(DetailedHistory.orderDetail, data)
                    }
                    activity?.startActivity(movetoOrderDetailed)
                }
                private fun putExtra(orderDetail: String, data: dataHistory) {
                }
            }
        )
    }
    private fun onCreateComponent(){
        adapter = historyAdapter(list)
    }

    private fun addOrderHistory(list: ArrayList<dataHistory>): ArrayList<dataHistory> {
        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth!!.currentUser
        myRef.child("Users").child(currentUser!!.uid).child("orderHistory")
            .addListenerForSingleValueEvent(object: ValueEventListener{
                override fun onCancelled(error: DatabaseError) {
                }
                override fun onDataChange(snapshot: DataSnapshot) {
                    list.clear()
                    for(order in snapshot.children){
                        val orderDetail = dataHistory()
                        orderDetail.orderID = order.child("orderID").value.toString()
                        orderDetail.orderDate = order.child("orderDate").value.toString()
                        orderDetail.orderRating = order.child("orderRating").value.toString()
                        orderDetail.orderSubject = order.child("orderSubject").value.toString()
                        orderDetail.tariff = order.child("tariff").value.toString()
                        orderDetail.tutorName = order.child("tutorName").value.toString()
                        orderDetail.tutorReview = order.child("tutorReview").value.toString()
                        list.add(orderDetail)
                        println(orderDetail.orderID) //bsia
                    }
                    adapter.notifyDataSetChanged()
                }
            })
        return list
    }
}


