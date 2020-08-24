package com.example.profileunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //GET FRAGMENTS
        val form = FormFragment()
//        val profile = ProfileFragment()

        //LOAD WELCOME PAGE
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, form)
            commit()
            addToBackStack(null)
        }
    }
}