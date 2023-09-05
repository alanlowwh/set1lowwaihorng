package com.example.set1lowwaihorng

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
    }

    private fun setListener(){
        val editTextName = findViewById<EditText>(R.id.editTextName)
//        val editTextCourseCode = findViewById<EditText>(R.id.editCourse)
        val spinnerCourses = findViewById<Spinner>(R.id.spinnerCourses)
        val editTextScore = findViewById<EditText>(R.id.editTextScore)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonContact = findViewById<Button>(R.id.buttonContact)
        val gradeView = findViewById<TextView>(R.id.gradeView)



        buttonCalculate.setOnClickListener {
            val name = editTextName.text.toString()
//            val courseCode = editTextCourseCode.text.toString()
            val courseCode = spinnerCourses.selectedItem.toString() // Get the selected course from the Spinner

            val score = editTextScore.text.toString().toInt()

            val grade = calculateGrade(score)

            // Display the result
            val resultText = "Name: $name\nCourse Code: $courseCode\nScore: $score\nGrade: $grade"
            gradeView.text = resultText
        }

        buttonContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:03-61261600"))
            startActivity(intent)

        }
    }

    private fun calculateGrade(score: Int): String {
        return when (score) {
            in 80..100 -> "A"
            in 75..79 -> "A-"
            in 70..74 -> "B+"
            in 65..69 -> "B"
            in 60..64 -> "B-"
            in 55..59 -> "C+"
            in 50..54 -> "C"
            in 0..49 -> "D"
            else -> "Invalid Score"
        }
    }
}