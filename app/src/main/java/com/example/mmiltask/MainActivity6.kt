package com.example.mmiltask

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity6 : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var unit: Spinner
    private lateinit var celsius: TextView
    private lateinit var fahrenheit: TextView
    private lateinit var kelvin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        input = findViewById(R.id.input3)
        unit = findViewById(R.id.unit3)
        celsius = findViewById(R.id.celsius)
        fahrenheit = findViewById(R.id.fahrenheit)
        kelvin = findViewById(R.id.kelvin)

        val arr = arrayOf("Celsius", "Fahrenheit", "Kelvin")
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
                "Celsius" -> setUnits(inputValue, 1.0, 33.8, 274.15)
                "Fahrenheit" -> setUnits(inputValue, -17.2222, 1.0, 255.928)
                "Kelvin" -> setUnits(inputValue, -272.15, -457.87, 1.0)
            }
        }
    }

    private fun setUnits(inputValue: Double, celsiusMultiplier: Double, fahrenheitMultiplier: Double, kelvinMultiplier: Double) {
        celsius.text = (inputValue * celsiusMultiplier).toString()
        fahrenheit.text = (inputValue * fahrenheitMultiplier).toString()
        kelvin.text = (inputValue * kelvinMultiplier).toString()
    }
}
