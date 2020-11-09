package com.tutorin.app.student

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
import com.tutorin.app.R
import com.tutorin.app.`object`.dataHistory
import com.tutorin.app.`object`.exampleData
import com.tutorin.app.adapter.historyAdapter
import java.util.zip.Inflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class HistoryFragment : Fragment() {
    private lateinit var rvHistory: RecyclerView
    private lateinit var root: View
    private var list: ArrayList<dataHistory> = arrayListOf()
    companion object {
        fun newInstance(): HistoryFragment = HistoryFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_history, container, false)
        rvHistory = root.findViewById(R.id.rv_history)
        rvHistory.setHasFixedSize(true)
        list.addAll(exampleData.listData)
        showRecycleList()
        return root
    }

    private fun showRecycleList(){
        rvHistory.layoutManager = LinearLayoutManager(activity)
        val listHeroAdapter = historyAdapter(list)
        rvHistory.adapter = listHeroAdapter
    }
}

