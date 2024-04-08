package com.example.lab05_api33

import android.os.Bundle // For saving the activity state (Android)
import androidx.activity.ComponentActivity // For creating a screen (Android) 
import androidx.activity.compose.setContent // Setting the content of the activity (Jetpack Compose)
import androidx.compose.foundation.layout.fillMaxSize // Filling the container with the content (Jetpack Compose)
import androidx.compose.material3.MaterialTheme // Defining the color scheme of the UI (Jetpack Compose)
import androidx.compose.material3.Surface // Defining the background color of the UI (Jetpack Compose)
import androidx.compose.material3.Text // Displaying text in the UI (Jetpack Compose)
import androidx.compose.runtime.Composable // Defining composable (Jetpack Compose)
import androidx.compose.ui.Modifier // Layout container (Jetpack Compose)
import androidx.compose.ui.text.font.FontWeight // Text weight (Jetpack Compose)
import androidx.compose.ui.text.style.TextAlign // Text alignment (Jetpack Compose)
import androidx.compose.ui.tooling.preview.Preview // Previewing the UI in the IDE (Jetpack Compose)
import androidx.compose.ui.unit.sp // Text size (scale-independent pixels)
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
