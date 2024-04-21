package com.example.input_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.input_sample.databinding.ActivityMainBinding // Import correct package
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Declare binding variable

    override fun onCreate(savedInstanceState: Bundle?) { // Fix function signature
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener { addNumbers() }
    }

    private fun addNumbers() {
        val num1Str = binding.editText1.text.toString()
        val num2Str = binding.editText2.text.toString()

        val num1 = num1Str.toInt()
        val num2 = num2Str.toInt()

        val result = num1 + num2

        binding.resultTextView.text = "Result: $result"
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Input_sampleTheme {
        Text(text = "Android") // Corrected function call
    }
}
