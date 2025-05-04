import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    
    // First i am PLanning to do the UI Colors and everything Around  :)

// Color 1 BaseMode

    val LightBackground = Color(0xFFF5F0E1)     // Sanftes Papierbeige
    val LightPrimary = Color(0xFF7B5E3B)        // Dunkles Lederbraun
    val LightSecondary = Color(0xFFC19A6B)      // Helles Goldbraun
    val LightAccent = Color(0xFFA67C52)         // Akzentton für Icons oder Buttons
    val LightTextPrimary = Color(0xFF3E3E3E)    // Warmes Dunkelgrau für Text
    val LightCardBackground = Color(0xFFFFFAF3) // Für Cards oder Verse

    // Night Mode

    val DarkBackground = Color(0xFF1F1B16)       // Dunkles Espresso-Braun
    val DarkPrimary = Color(0xFF5A4228)          // Lederoptik mit Tiefe
    val DarkSecondary = Color(0xFF8E7355)        // Goldenes Braun
    val DarkAccent = Color(0xFFBFA276)           // Für Buttons & Hervorhebung
    val DarkTextPrimary = Color(0xFFECE6DA)      // Warmes Off-White
    val DarkCardBackground = Color(0xFF2C251D)   // Etwas helleres Braun für Card-Kontrast

// Diferent UI Eelements Modifiers Pre Usage Modifiers :)

    val boxModifier = Modifier
        .fillMaxWidth() // Füllt die gesamte Breite des Bildschirms
        .padding(16.dp) // Fügt Abstand rund um die Box hinzu
        .background(LightCardBackground, shape = RoundedCornerShape(12.dp)) // Hintergrundfarbe mit abgerundeten Ecken
        .shadow(8.dp, shape = RoundedCornerShape(12.dp)) // <- ohne `color`


    val buttonModifier = Modifier
        .fillMaxWidth() // Button füllt die ganze Breite
        .padding(16.dp) // Abstand rund um den Button
        .height(56.dp) // Feste Höhe für eine angenehme Klickbarkeit
        .clip(RoundedCornerShape(8.dp)) // Abgerundete Ecken für den Button

    val textModifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp) // Abstand rund um den Text
        .fillMaxWidth() // Der Text füllt die Breite der Box

    val imageModifier = Modifier
        .fillMaxWidth() // Bild füllt die gesamte Breite
        .height(200.dp) // Feste Höhe des Bildes
        .clip(RoundedCornerShape(12.dp)) // Abgerundete Ecken für das Bild
        .padding(16.dp) // Abstand rund um das Bild

    val dividerModifier = Modifier
        .fillMaxWidth() // Der Divider füllt die Breite aus
        .height(1.dp) // Dünne Linie
        .background(Color.Gray.copy(alpha = 0.5f)) // Graue Linie
        .padding(vertical = 8.dp) // Abstand ober- und unterhalb der Linie







    var text by remember { mutableStateOf("Bible") }

    MaterialTheme {

Column(

    modifier = Modifier
        .fillMaxSize()
        .background(LightBackground)
        .padding(16.dp)) {

    // First Element

    Text(
        text = "Willkommen in der Bibel-App",
        modifier = textModifier,
        style = MaterialTheme.typography.h4.copy(color = LightPrimary),
        textAlign = TextAlign.Center
    )


    Text(
        text = "Dein täglicher geistlicher Begleiter",
        modifier = textModifier,
            style = MaterialTheme.typography.h6.copy(color =LightSecondary),
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(24.dp))// Extra Cooler und großen Abstand zu haben

    Button(
        onClick = {
            text = "Jesus is the Way!" // Action for the button
        },
        modifier = buttonModifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = LightAccent)
    ) {
        Text(text = "Start") // Button Text
    }
    Spacer(modifier = Modifier.height(24.dp))

    // Text to show the change from the button
    Text(
        text = text,
        style = MaterialTheme.typography.h5.copy(color = LightTextPrimary),
        textAlign = TextAlign.Center
    )



}








    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
