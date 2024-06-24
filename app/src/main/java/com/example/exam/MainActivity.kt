
package com.example.exam

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var backgroundLayout: LinearLayout
    private lateinit var colorSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backgroundLayout = findViewById(R.id.backgroundLayout)
        colorSpinner = findViewById(R.id.colorSpinner)

        // Define colors and their corresponding names
        val colors = arrayOf("Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "White", "Black")
        val colorValues = arrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.WHITE, Color.BLACK)

        // Set up the spinner with color names
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        colorSpinner.adapter = adapter

        // Set listener to change background color when a color is selected
        colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                backgroundLayout.setBackgroundColor(colorValues[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }
}
