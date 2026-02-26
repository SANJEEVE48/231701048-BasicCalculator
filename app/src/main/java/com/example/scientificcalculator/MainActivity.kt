package com.example.scientificcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etValue1: EditText
    private lateinit var etValue2: EditText
    private lateinit var etResult: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMul: Button
    private lateinit var btnDiv: Button
    private lateinit var btnMod: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etValue1 = findViewById(R.id.etValue1)
        etValue2 = findViewById(R.id.etValue2)
        etResult = findViewById(R.id.etResult)

        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)
        btnMod = findViewById(R.id.btnMod)

        btnAdd.setOnClickListener { calculate("+") }
        btnSub.setOnClickListener { calculate("-") }
        btnMul.setOnClickListener { calculate("*") }
        btnDiv.setOnClickListener { calculate("/") }
        btnMod.setOnClickListener { calculate("%") }
    }

    private fun calculate(operator: String) {
        val s1 = etValue1.text.toString()
        val s2 = etValue2.text.toString()

        if (s1.isEmpty() || s2.isEmpty()) {
            etResult.setText("Enter values")
            return
        }

        try {
            val num1 = s1.toDouble()
            val num2 = s2.toDouble()
            var result = 0.0

            when (operator) {
                "+" -> result = num1 + num2
                "-" -> result = num1 - num2
                "*" -> result = num1 * num2
                "/" -> {
                    if (num2 != 0.0) {
                        result = num1 / num2
                    } else {
                        etResult.setText("Div by 0")
                        return
                    }
                }
                "%" -> result = num1 % num2
            }

            etResult.setText(result.toString())
        } catch (e: NumberFormatException) {
            etResult.setText("Invalid Input")
        }
    }
}
