package com.example.lab05_traditional_api27

import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var smallPizza : RadioButton
    private lateinit var mediumPizza : RadioButton
    private lateinit var largePizza : RadioButton
    private lateinit var onionsCheckBox : CheckBox
    private lateinit var olivesCheckBox : CheckBox
    private lateinit var tomatoesCheckBox : CheckBox
    private lateinit var totalPrice : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smallPizza = findViewById(R.id.smallpizza)
        mediumPizza = findViewById(R.id.mediumpizza)
        largePizza = findViewById(R.id.largepizza)
        onionsCheckBox = findViewById(R.id.OnionsCheckBox)
        olivesCheckBox = findViewById(R.id.OlivesCheckBox)
        tomatoesCheckBox = findViewById(R.id.TomatoesCheckBox)
        totalPrice = findViewById(R.id.Totalprice)

    }

    fun onPlaceOrderButtonClicked() {
        val pizzaSizePrice = when {
            smallPizza.isChecked -> 5.0
            mediumPizza.isChecked -> 7.0
            largePizza.isChecked -> 9.0
            else -> 0.0 // Default case
        }

        val toppingsPrice = calculateToppingsPrice()

        val totalPrice = pizzaSizePrice + toppingsPrice
        val totalPriceString = getString(R.string.total_order_price, totalPrice)

        // Assuming totalPriceTextView is a TextView with id totalPrice
        val totalPriceTextView: TextView = findViewById(R.id.Totalprice)
        totalPriceTextView.text = totalPriceString
    }

    private fun calculateToppingsPrice(): Double {
        var toppingsTotal = 0.0
        if (onionsCheckBox.isChecked) {
            toppingsTotal += 1
        }
        if (olivesCheckBox.isChecked) {
            toppingsTotal += 2
        }
        if (tomatoesCheckBox.isChecked) {
            toppingsTotal += 3
        }
        return toppingsTotal
    }
}