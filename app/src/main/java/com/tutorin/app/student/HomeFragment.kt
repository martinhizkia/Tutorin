package com.tutorin.app.student

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tutorin.app.R
import com.tutorin.app.business
import kotlinx.android.synthetic.main.activity_business.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        view.buttonBusiness.setOnClickListener {
            val intent=Intent(activity,business::class.java)
            intent.putExtra("Topics", "Business")
            startActivity(intent)
        }
        view.buttonEngineering.setOnClickListener {
            val intent=Intent(activity,business::class.java)
            intent.putExtra("Topics", "Engineering")
            startActivity(intent)
        }
        view.buttonHumanities.setOnClickListener {
            val intent=Intent(activity,business::class.java)
            intent.putExtra("Topics", "Humanities")
            startActivity(intent)
        }
        view.buttonMedicals.setOnClickListener {
            val intent=Intent(activity,business::class.java)
            intent.putExtra("Topics", "Medicals")
            startActivity(intent)
        }
        view.buttonIT.setOnClickListener {
            val intent=Intent(activity,business::class.java)
            intent.putExtra("Topics", "IT & Development")
            startActivity(intent)
        }
        view.buttonLaws.setOnClickListener {
            val intent=Intent(activity,business::class.java)
            intent.putExtra("Topics", "Laws")
            startActivity(intent)
        }

        return view
    }
}