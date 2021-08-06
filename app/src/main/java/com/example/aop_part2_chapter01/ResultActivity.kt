package com.example.aop_part2_chapter01

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height: $height, weight: $weight")

        val bmi = weight / (height / 100.0).pow(2.0)
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중경도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        }

        val bmiResultIntTxt = findViewById<TextView>(R.id.bmiResultIntTxt)
        val bmiResultStringTxt = findViewById<TextView>(R.id.bmiResultStringTxt)

        bmiResultIntTxt.text = bmi.toString()
        bmiResultStringTxt.text = "$resultText 입니다."
    }
}