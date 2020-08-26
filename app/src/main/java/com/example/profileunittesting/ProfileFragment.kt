package com.example.profileunittesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        //GET PROFILE FIELDS
        val nameField = view.findViewById<TextView>(R.id.name_field)
        val phoneField = view.findViewById<TextView>(R.id.phone_field)
        val emailField = view.findViewById<TextView>(R.id.email_field)
        val sexField = view.findViewById<TextView>(R.id.sex_field)


        //GET FORM INFO
        val bundle = this.arguments
        val name = bundle?.get("name")
        val phone = bundle?.get("phone")
        val email = bundle?.get("email")
        val sex = bundle?.get("sex")

        //SET PROFILE FIELDS
        nameField.text = name.toString()
        phoneField.text = phone.toString()
        emailField.text = email.toString()
        sexField.text = sex.toString()

        return view
    }

}