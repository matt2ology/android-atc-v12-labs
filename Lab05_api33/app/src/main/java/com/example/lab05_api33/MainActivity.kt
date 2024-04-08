package com.example.lab05_api33

import android.os.Bundle // For saving the activity state (Android)
import androidx.activity.ComponentActivity // For creating a screen (Android) 
import androidx.activity.compose.setContent // Setting the content of the activity (Jetpack Compose)
import androidx.compose.foundation.layout.Column // Layout container for stacking elements vertically
import androidx.compose.material3.MaterialTheme // Defining the color scheme of the UI (Jetpack Compose)
import androidx.compose.material3.Surface // Defining the background color of the UI (Jetpack Compose)
import androidx.compose.material3.Text // Displaying text in the UI (Jetpack Compose)
import androidx.compose.runtime.Composable // Defining composable (Jetpack Compose)
import androidx.compose.ui.Modifier // Layout container (Jetpack Compose)
import androidx.compose.ui.text.font.FontWeight // Text weight (Jetpack Compose)
import androidx.compose.ui.text.style.TextAlign // Text alignment (Jetpack Compose)
import androidx.compose.ui.tooling.preview.Preview // Previewing the UI in the IDE (Jetpack Compose)
import androidx.compose.ui.unit.sp // Text size (scale-independent pixels)
import androidx.compose.ui.unit.dp // Density-independent pixels
import androidx.compose.foundation.Image // Displaying images in the UI
import androidx.compose.foundation.layout.padding // Adding padding for spacing
import androidx.compose.foundation.layout.size // Setting the size of the image
import androidx.compose.ui.res.painterResource // Loading images from resources
import androidx.compose.ui.Alignment // Aligning elements in the UI
import com.example.lab05_api33.ui.theme.Lab05_api33Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab05_api33Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column( // Column layout container to stacking elements vertically
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TitleText("Android Pizza Shop")
                        DisplayImage(R.drawable.pizza)
                    }
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
        // center text on screen
        textAlign = TextAlign.Center,
        // Add padding around the text and fill the container with the text
        modifier = Modifier.padding(25.dp)
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

@Composable
fun DisplayImage(imageResourceId: Int) {
    Image(
        painter = painterResource(id = imageResourceId),
        contentDescription = null,
        // modifier increase image size by 50%
        modifier = Modifier.size(150.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DisplayImagePreview() {
    Lab05_api33Theme {
        // Preview the DisplayImage composable with a sample image resource ID
        DisplayImage(R.drawable.pizza)
    }
}
