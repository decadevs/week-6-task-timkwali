package com.example.profileunittesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_form.*


class FormFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // INFLATE THE LAYOUT FOR THIS FRAGMENT
        val view: View = inflater.inflate(R.layout.fragment_form, container, false)
        val text = view.findViewById<EditText>(R.id.text)
        val register = view.findViewById<Button>(R.id.register)
        register.setOnClickListener() {

            //GET FORM INFORMATION
            val bundle = Bundle()
            bundle.putString("text", text.text.toString())

//            Toast.makeText(this.context, text.text.toString(), Toast.LENGTH_SHORT).show()
            //GET PROFILE FRAGMENT AND MOVE TO IT
            val profile = ProfileFragment()
            profile.arguments = bundle
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.main_container, profile)
                commit()
                addToBackStack(null)
            }
        }

        return view
    }
}