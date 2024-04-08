package com.example.lab05_api33

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lab05_api33.ui.theme.Lab05_api33Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab05_api33Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), // Fill the container with the content
                    color = MaterialTheme.colorScheme.background // Set the background color of the UI
                ) {
                    // Display the text "Android Pizza Shop" with specified text size and style
                    TitleText("Android Pizza Shop")
                }
            }
        }
    }
}

@Composable // Composable function for displaying text in the UI (Jetpack Compose)
fun TitleText(text: String) {
    Text(
        text = text, // Text to be displayed in the UI
        fontSize = 34.sp, // Text size in scale-independent pixels
        fontWeight = FontWeight.Bold, // Text weight (bold)
        textAlign = TextAlign.Center, // Text alignment (center)
        modifier = Modifier.fillMaxSize() // Fill the container with the content
    )
}

@Preview(showBackground = true) // Preview the UI with a background color (Jetpack Compose)
@Composable // Composable function for previewing the UI in the IDE (Jetpack Compose)
fun TitleTextPreview(){
    Lab05_api33Theme {
        // Preview using TitleText composable
        TitleText("Android Pizza Shop")
    }
}
