package com.example.aop_part2_chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

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

            val womanBtn = findViewById<RadioButton>(R.id.womanBtn)
            val manBtn = findViewById<RadioButton>(R.id.manBtn)
            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.womanBtn -> womanBtn.text = "woman"
                    R.id.manBtn -> manBtn.text = "man"
                    else -> {
                        Toast.makeText(this, "성별을 선택해주세요.", Toast.LENGTH_SHORT).show()
                    }
                }

//            이 아래로는 절대 빈 값이 올 수 없음

                val height: Int = heightEdt.text.toString().toInt()
                val weight: Int = weightEdt.text.toString().toInt()
                val woman: String = womanBtn.text.toString()
                val man: String = manBtn.text.toString()


                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("height", height)
                    .putExtra("weight", weight)
                    .putExtra("woman", woman)
                    .putExtra("man", man)
                startActivity(intent)
            }
        }
    }
}