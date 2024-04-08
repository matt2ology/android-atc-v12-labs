package com.example.lab01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {
    var num1 by remember { mutableStateOf(0f) }
    var num2 by remember { mutableStateOf(0f) }
    var result by remember { mutableStateOf(0f) }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculator App",
            fontSize = 24.sp
        )
        OutlinedTextField(
            value = num1.toString(),
            onValueChange = { num1 = it.toFloatOrNull() ?: 0f },
            label = { Text("Enter Number 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = num2.toString(),
            onValueChange = { num2 = it.toFloatOrNull() ?: 0f },
            label = { Text("Enter Number 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { result = num1 + num2 }) {
                Text("+")
            }
            Button(onClick = { result = num1 - num2 }) {
                Text("-")
            }
            Button(onClick = { result = num1 * num2 }) {
                Text("x")
            }
            Button(onClick = {
                if (num2 != 0f) {
                    result = num1 / num2
                    showError = false
                } else {
                    // Show error message
                    showError = true
                }
            }) {
                Text("/")
            }
        }
        if (showError) {
            Text(
                text = "Don't divide by zero",
                fontSize = 20.sp
            )
        } else {
            Text(
                text = "Result: $result",
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorApp()
}
