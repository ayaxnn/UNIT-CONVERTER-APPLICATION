package com.example.mmiltask

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var unit: Spinner
    private lateinit var seconds: TextView
    private lateinit var minutes: TextView
    private lateinit var hours: TextView
    private lateinit var days: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        input = findViewById(R.id.input1)
        unit = findViewById(R.id.unit1)
        seconds = findViewById(R.id.seconds)
        minutes = findViewById(R.id.minutes)
        hours = findViewById(R.id.hours)
        days = findViewById(R.id.days)

        val arr = arrayOf("Seconds", "Minutes", "Hours", "Days")
        unit.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)

        unit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                update()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable?) {
                update()
            }
        })
    }

    private fun update() {
        if (!input.text.toString().isEmpty() && unit.selectedItem.toString() != "") {
            val inputValue = input.text.toString().toDouble()
            when (unit.selectedItem.toString()) {
                "Seconds" -> setUnits(inputValue, 1.0, 1.0 / 60, 1.0 / 3600, 1.0 / 86400)
                "Minutes" -> setUnits(inputValue, 60.0, 1.0, 1.0 / 60, 1.0 / 1440)
                "Hours" -> setUnits(inputValue, 3600.0, 60.0, 1.0, 1.0 / 24)
                "Days" -> setUnits(inputValue, 86400.0, 1440.0, 24.0, 1.0)
            }
        }
    }

    private fun setUnits(inputValue: Double, secondsMultiplier: Double, minutesMultiplier: Double, hoursMultiplier: Double, daysMultiplier: Double) {
        seconds.text = (inputValue * secondsMultiplier).toString()
        minutes.text = (inputValue * minutesMultiplier).toString()
        hours.text = (inputValue * hoursMultiplier).toString()
        days.text = (inputValue * daysMultiplier).toString()
    }
}
