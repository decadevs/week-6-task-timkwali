package com.example.profileunittesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_form.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class FormFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //DECLARE FORM FIELDS
    lateinit var name: EditText
    lateinit var phone: EditText
    lateinit var email: EditText
    lateinit var sex: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // INFLATE THE LAYOUT FOR THIS FRAGMENT
        val view: View = inflater.inflate(R.layout.fragment_form, container, false)

        //INITIALIZE FORM FIELDS
        name = view.findViewById<EditText>(R.id.name)
        phone = view.findViewById<EditText>(R.id.phone)
        email = view.findViewById<EditText>(R.id.email)
        sex = view.findViewById<Spinner>(R.id.sex)
        val register = view.findViewById<Button>(R.id.register)
        register.setOnClickListener() {

            //VALIDATE FORM
//            validateName()
//            validatePhone()
//            validateEmail()

            if(validateName() && validatePhone() && validateEmail()) {
                //SAVE FORM INFO IN BUNDLE
                val bundle = Bundle()
                bundle.putString("name", name.text.toString())
                bundle.putString("phone", phone.text.toString())
                bundle.putString("email", email.text.toString())
                bundle.putString("sex", sex.selectedItem.toString())

                //MOVE TO PROFILES FRAGMENT
                val profile = ProfileFragment()
                profile.arguments = bundle
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.main_container, profile)
                    commit()
                    addToBackStack(null)
                }
            }
        }
        return view
    }

    //FORM VALIDATIONS
    //VALIDATE NAME FIELD
    private fun validateName(): Boolean {

        val value: String = name.text.toString().trim()
        val name = "Name"
        //CHECK IF FIELD IS EMPTY
        if(checkIfEmpty(value, name)) return false

        //CHECK IF NAME IS TOO SHORT
        if(value.length < 3) {
            val message = "Name is too short!"
            Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
            return false
        }
        //CHECK IF NAME START WITH NUMBER
        if(value[0].isDigit()) {
            val message = "Name cannot start with a digit!"
            Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    //VALIDATE PHONE FIELD
    private fun validatePhone(): Boolean {

        val value: String = phone.text.toString().trim()
        val name = "Phone Number"
        var message = ""
        //CHECK IF FIELD IS EMPTY
        if(checkIfEmpty(value, name)) return false

        //CHECK IF NUMBER IS NIGERIAN
        if(value[0] == '0') {
            if (value.length != 11) {
                message = "Phone number should be 11 digits!"
                Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
                return false
            }
        } else if(value[0] == '2') {
            if(value.length != 13) {
                message = "Phone Number should be 13 digits!"
                Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
                return false
            }
        } else {
            message = "Please input a valid Nigerian number!"
            Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    //VALIDATE EMAIL FIELD
    private fun validateEmail(): Boolean {

        val value: String = email.text.toString().trim()
        val name = "Email"
        //CHECK IF FIELD IS EMPTY
        if(checkIfEmpty(value, name)) return false

        //CHECK IF EMAIL IS VALID
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return if(value.matches(emailPattern.toRegex()) ) {
            true
        } else {
            val message = "Please enter a valid email address"
            Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
            false
        }
    }

    //CHECK IF FIELD IS EMPTY
    private fun checkIfEmpty(str: String, name: String): Boolean {
        if(str.isEmpty())  {
            val message = "$name cannot be empty!"
            Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}