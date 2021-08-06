package com.example.aop_part2_chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEdt: EditText = findViewById(R.id.heightEdt)
        val weightEdt = findViewById<EditText>(R.id.weightEdt)

        val resultBtn = findViewById<Button>(R.id.resultBtn)

        resultBtn.setOnClickListener {
            Log.d("MainActivity", "ResultButton 클릭됨")

            if (heightEdt.text.isEmpty() || weightEdt.text.isEmpty()) {

                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

//            이 아래로는 절대 빈 값이 올 수 없음

            val height: Int = heightEdt.text.toString().toInt()
            val weight: Int = weightEdt.text.toString().toInt()


        }
    }
}