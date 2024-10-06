package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var userInput: EditText
    private lateinit var countOption: Spinner
    private lateinit var countButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        userInput = findViewById(R.id.userInput)
        countOption = findViewById(R.id.countOption)
        countButton = findViewById(R.id.countButton)
        resultTextView = findViewById(R.id.resultTextView)


        val options = arrayOf(getString(R.string.count_words), getString(R.string.count_chars))
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countOption.adapter = adapter


        countButton.setOnClickListener { calculateCount() }
    }

    private fun calculateCount() {
        val input = userInput.text.toString()
        if (input.isBlank()) {
            Toast.makeText(this, getString(R.string.empty_input_warning), Toast.LENGTH_SHORT).show()
            return
        }

        val selectedOption = countOption.selectedItem.toString()

        val counter = CounterUtil()
        val total = when (selectedOption) {
            getString(R.string.count_words) -> counter.getWordCount(input)
            else -> counter.getCharCount(input)
        }

        resultTextView.text = getString(R.string.result_label) + total
    }
}