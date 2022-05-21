package com.example.examenparcial_diegoalonsoolivera_ws7c.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.examenparcial_diegoalonsoolivera_ws7c.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()
    }

    private fun initView() {
        val btDetails = findViewById<Button>(R.id.btDetails)
        val btList = findViewById<Button>(R.id.btList)

        btDetails.setOnClickListener {
            startActivity(Intent(this, Detail::class.java))
        }

        btList.setOnClickListener {
            startActivity(Intent(this, Lists::class.java))
        }
    }
}