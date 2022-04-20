package com.example.app_sem4_ses1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var questions : ArrayList<Question>
    var position = 0
    val maxPosition = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setUpViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("¿Es Arica capital de Bolivia?", false)
        questions.add(question)

        questions.add(Question("¿Es Arica capital de Lima?", false))
        questions.add(Question("¿Es Lima capital de Perú?", true))
        questions.add(Question("¿Es Santiago capital de Lima?", false))
        questions.add(Question("¿Es Santiago capital de Chile?", true))
        questions.add(Question("¿Es la Paz capital de Brasil?", false))
    }

    private fun setUpViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val tvQuestion = findViewById<TextView>(R.id.tvSentence)
        val btNext = findViewById<Button>(R.id.btNext)

        tvQuestion.text = questions[position].sentence

        btYes.setOnClickListener {
            if (questions[position].answer)
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
        btNo.setOnClickListener {
            if (!questions[position].answer)
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }

        btNext.setOnClickListener {
            position++
            if (position > maxPosition)
                position = 0

            tvQuestion.text = questions[position].sentence
        }
    }
}