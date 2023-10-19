package com.example.gradeformconverter

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare the UI components
    private lateinit var editTextNilaiTugas: EditText
    private lateinit var editTextNilaiKuis: EditText
    private lateinit var editTextNilaiETS: EditText
    private lateinit var editTextNilaiEAS: EditText
    private lateinit var editTextNilaiFP: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the UI components
        editTextNilaiTugas = findViewById(R.id.editText_nilaiTugas)
        editTextNilaiKuis = findViewById(R.id.editText_nilaiKuis)
        editTextNilaiETS = findViewById(R.id.editText_nilaiETS)
        editTextNilaiEAS = findViewById(R.id.editText_nilaiEAS)
        editTextNilaiFP = findViewById(R.id.editText_nilaiFP)
        buttonCalculate = findViewById(R.id.button_calculate)
        textViewResult = findViewById(R.id.textView_result)

        // Set click listener to the Calculate Grade button
        buttonCalculate.setOnClickListener {
            val average = calculateAverage()
            val grade = getGrade(average)
            showDialog(grade)
        }
    }

    private fun calculateAverage(): Double {
        val nilaiTugas = editTextNilaiTugas.text.toString().toDoubleOrNull() ?: 0.0
        val nilaiKuis = editTextNilaiKuis.text.toString().toDoubleOrNull() ?: 0.0
        val nilaiETS = editTextNilaiETS.text.toString().toDoubleOrNull() ?: 0.0
        val nilaiEAS = editTextNilaiEAS.text.toString().toDoubleOrNull() ?: 0.0
        val nilaiFP = editTextNilaiFP.text.toString().toDoubleOrNull() ?: 0.0

        return (nilaiTugas + nilaiKuis + nilaiETS + nilaiEAS + nilaiFP) / 5
    }

    private fun getGrade(nilai: Double): String {
        return when {
            nilai >= 86 -> "A"
            nilai >= 76 -> "AB"
            nilai >= 66 -> "B"
            nilai >= 61 -> "BC"
            nilai >= 56 -> "C"
            nilai >= 41 -> "D"
            else -> "E"
        }
    }

    private fun showDialog(grade: String) {
        AlertDialog.Builder(this)
            .setTitle("Your Grade")
            .setMessage("Your average grade is: $grade")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
