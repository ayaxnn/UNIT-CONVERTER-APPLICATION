package com.example.mmiltask

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity5 : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var unit: Spinner
    private lateinit var grams: TextView
    private lateinit var kilograms: TextView
    private lateinit var ounces: TextView
    private lateinit var pounds: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        input = findViewById(R.id.input2)
        unit = findViewById(R.id.unit2)
        grams = findViewById(R.id.grams)
        kilograms = findViewById(R.id.kilograms)
        ounces = findViewById(R.id.ounces)
        pounds = findViewById(R.id.pounds)

        val arr = arrayOf("Grams", "Kilograms", "Ounces", "Pounds")
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
                "Grams" -> setUnits(inputValue, 1.0, 0.001, 0.03527396, 0.002204623)
                "Kilograms" -> setUnits(inputValue, 1000.0, 1.0, 35.27396, 2.204623)
                "Ounces" -> setUnits(inputValue, 28.34952, 0.02834952, 1.0, 0.0625)
                "Pounds" -> setUnits(inputValue, 453.5924, 0.4535924, 16.0, 1.0)
            }
        }
    }

    private fun setUnits(inputValue: Double, gramsMultiplier: Double, kilogramsMultiplier: Double, ouncesMultiplier: Double, poundsMultiplier: Double) {
        grams.text = (inputValue * gramsMultiplier).toString()
        kilograms.text = (inputValue * kilogramsMultiplier).toString()
        ounces.text = (inputValue * ouncesMultiplier).toString()
        pounds.text = (inputValue * poundsMultiplier).toString()
    }
}
