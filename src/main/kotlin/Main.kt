import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        BibleApp()
    }
}

@Composable
fun BibleApp() {
    // Farbdefinitionen
    val LightBackground = Color(0xFFF5F0E1)
    val LightPrimary = Color(0xFF7B5E3B)
    val LightSecondary = Color(0xFFC19A6B)
    val LightAccent = Color(0xFFA67C52)
    val LightTextPrimary = Color(0xFF3E3E3E)
    val LightCardBackground = Color(0xFFFFFAF3)

    // Zustand für den Button-Text
    var buttonText by remember { mutableStateOf("Bible") }

    MaterialTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBackground)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Titel und Slogan
                Text(
                    text = "Willkommen in der Bibel-App",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Dein täglicher geistlicher Begleiter.",
                    fontSize = 18.sp,
                    color = LightSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                // Tagesvers-Box
                Card(
                    backgroundColor = LightCardBackground,
                    shape = RoundedCornerShape(12.dp),
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "\"Denn also hat Gott die Welt geliebt...\"",
                            fontSize = 16.sp,
                            color = LightTextPrimary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "(Johannes 3,16)",
                            fontSize = 14.sp,
                            color = LightSecondary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                // Andacht zum Vers
                Card(
                    backgroundColor = LightCardBackground,
                    shape = RoundedCornerShape(12.dp),
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Heute geht es um Gottes Liebe, die...",
                            fontSize = 16.sp,
                            color = LightTextPrimary
                        )
                        Text(
                            text = "...",
                            fontSize = 14.sp,
                            color = LightTextPrimary
                        )
                    }
                }

                // Horizontale Icons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { /* TODO */ }) {
                        Text("📖 Lesepläne")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Text("⭐ Favoriten")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Text("📤 Teilen")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Text("🕊️ Gebet")
                    }
                }

                // Was ist die Bibel? – Info
                Card(
                    backgroundColor = LightCardBackground,
                    shape = RoundedCornerShape(12.dp),
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Was ist die Bibel?",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightPrimary
                        )
                        Text(
                            text = "Die Bibel ist eine Sammlung heiliger Schriften...",
                            fontSize = 14.sp,
                            color = LightTextPrimary
                        )
                    }
                }

                // Empfohlene Lesepläne (LazyRow)
                Text(
                    text = "Empfohlene Lesepläne",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                val leseplaene = listOf("Markus", "Psalmen", "Ostern", "Genesis", "Exodus")

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    items(leseplaene) { plan ->
                        Card(
                            backgroundColor = LightCardBackground,
                            shape = RoundedCornerShape(12.dp),
                            elevation = 4.dp,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .width(120.dp)
                                .height(80.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = plan,
                                    fontSize = 14.sp,
                                    color = LightTextPrimary
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Button
                Button(
                    onClick = {
                        buttonText = "Jesus is the Way!"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = LightAccent)
                ) {
                    Text(text = "Start", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Text nach Button-Klick
                Text(
                    text = buttonText,
                    fontSize = 16.sp,
                    color = LightTextPrimary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Bottom Navigation
                Divider(color = Color.Gray, thickness = 1.dp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text("🏠 Start")
                    Text("📚 Bibel")
                    Text("🗓️ Pläne")
                    Text("⚙️ Einstellungen")
                }
            }
        }
    }
}
