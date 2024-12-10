package com.example.diamondapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        val inputNumber = findViewById<EditText>(R.id.inputNumber)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val outputTextView = findViewById<TextView>(R.id.outputTextView)


        generateButton.setOnClickListener {
            val userInput = inputNumber.text.toString()

            if (userInput.isNotEmpty()) {
                val size = userInput.toIntOrNull()
                if (size != null && size > 0) {
                    val diamond = generateDiamond(size)
                    outputTextView.text = diamond
                } else {
                    outputTextView.text = "Please enter a valid positive number."
                }
            } else {
                outputTextView.text = "Input cannot be empty."
            }
        }
    }

    private fun generateDiamond(n: Int): String {
        val diamond = StringBuilder()


        for (i in 1..n) {
            val spaces = " ".repeat(n - i)
            val stars = "*".repeat(2 * i - 1)
            diamond.append(spaces).append(stars).append("\n")
        }


        for (i in n - 1 downTo 1) {
            val spaces = " ".repeat(n - i)
            val stars = "*".repeat(2 * i - 1)
            diamond.append(spaces).append(stars).append("\n")
        }

        return diamond.toString()
    }
}
