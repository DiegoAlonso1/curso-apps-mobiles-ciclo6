package com.example.examenparcial_diegoalonsoolivera_ws7c.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenparcial_diegoalonsoolivera_ws7c.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        startActivity(Intent(this, Home::class.java))
    }
}