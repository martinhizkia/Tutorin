package com.tutorin.app.student

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tutorin.app.R
import com.tutorin.app.Topics
import com.tutorin.app.`object`.dataHome
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match

class HomeFragment : Fragment() {

    companion object {
        const val TOPICS_NAME = ""
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        view.buttonBusiness.setOnClickListener {
            val intent= Intent(activity,Topics::class.java)
                .putExtra(TOPICS_NAME,dataHome("Business", ""))
            startActivity(intent)
        }
        view.buttonEngineering.setOnClickListener {
            val intent=Intent(activity,Topics::class.java)
                .putExtra(TOPICS_NAME,dataHome("Engineering", ""))
            startActivity(intent)
        }
        view.buttonHumanities.setOnClickListener {
            val intent=Intent(activity,Topics::class.java)
                .putExtra(TOPICS_NAME,dataHome("Humanities", ""))
            startActivity(intent)
        }
        view.buttonMedicals.setOnClickListener {
            val intent=Intent(activity,Topics::class.java)
                .putExtra(TOPICS_NAME,dataHome("Medicals", ""))
            startActivity(intent)
        }
        view.buttonIT.setOnClickListener {
            val intent=Intent(activity,Topics::class.java)
                .putExtra(TOPICS_NAME,dataHome("IT & Development", ""))
            startActivity(intent)
        }
        view.buttonLaws.setOnClickListener {
            val intent=Intent(activity,Topics::class.java)
                .putExtra(TOPICS_NAME,dataHome("Laws", ""))
            startActivity(intent)
        }

        return view
    }
}