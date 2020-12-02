package com.tutorin.app.student

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tutorin.app.R
import com.tutorin.app.Register
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val myView: View = inflater.inflate(R.layout.fragment_profile, container, false)
        val btnUpdateProfile = myView.findViewById<TextView>(R.id.btnUpdateProfile)
        btnUpdateProfile.setOnClickListener {
            val intent = Intent (activity, UpdateProfile::class.java)
            startActivity(intent)
        }
        return myView

    }

}