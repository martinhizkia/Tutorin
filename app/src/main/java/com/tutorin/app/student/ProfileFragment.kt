package com.tutorin.app.student

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.tutorin.app.*
import com.tutorin.app.R
import com.tutorin.app.`object`.dataHistory
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private lateinit var myView: View
    private lateinit var auth: FirebaseAuth
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef: DatabaseReference = database.reference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val myView: View = inflater.inflate(R.layout.fragment_profile, container, false)
        val btnUpdateProfile = myView.findViewById<TextView>(R.id.btnUpdateProfile)
        val btnPrivacyPolicy = myView.findViewById<TextView>(R.id.privacy_policy)
        val btnTermsofService = myView.findViewById<TextView>(R.id.terms_of_service)
        val btnLogOut = myView.findViewById<Button>(R.id.btnLogOut)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth!!.currentUser
        readUserData()
        btnUpdateProfile.setOnClickListener {
            val intent = Intent (activity, UpdateProfile::class.java)
            startActivity(intent)
        }
        btnLogOut.setOnClickListener {
            auth.signOut()
            Intent(activity, Login::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
        btnPrivacyPolicy.setOnClickListener{
            val intent = Intent(activity, PrivacyPolicy::class.java)
            startActivity(intent)
        }
        btnTermsofService.setOnClickListener{
            val intent = Intent(activity, TermsofService::class.java)
            startActivity(intent)
        }
        return myView
    }

    private fun readUserData(){
        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth!!.currentUser
        myRef.child("Users").child(currentUser!!.uid)
            .addListenerForSingleValueEvent(object: ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                }
                override fun onDataChange(snapshot: DataSnapshot) {
                    var map = snapshot.value as Map<String,Any>
                    user_name.text = map["fullName"].toString()
                    user_phonenumber.text = map["phoneNum"].toString()
                    user_email.text = map["userEmail"].toString()
                }
            })
    }

}