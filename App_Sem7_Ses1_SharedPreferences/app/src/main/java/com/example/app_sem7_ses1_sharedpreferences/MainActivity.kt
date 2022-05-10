package com.example.app_sem7_ses1_sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = SharedPreferences(this)

        val btSave = findViewById<Button>(R.id.btSave)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val btRetrieve = findViewById<Button>(R.id.btRetrieve)
        val tvRetrieve = findViewById<TextView>(R.id.tvRetrieve)

        btSave.setOnClickListener {
            val name = etName.text.toString()
            sharedPreferences.save("name", name)
            Toast.makeText(this, "Data grabada", Toast.LENGTH_SHORT).show()
        }

        btRetrieve.setOnClickListener {
            val name = sharedPreferences.getValue("name")
            if (name != null) {
                tvRetrieve.setText(name)
            }
            Toast.makeText(this, "Data obtenida", Toast.LENGTH_SHORT).show()
        }
    }
}