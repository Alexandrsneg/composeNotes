package ru.alexandrsneg.composenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.compose.NavHost
import ru.alexandrsneg.composenotes.navigation.NotesNavHost
import ru.alexandrsneg.composenotes.ui.theme.ComposeNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotesTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Notes App")
                            },
                            backgroundColor = Color.Blue,
                            contentColor = Color.White,
                            elevation = 12.dp,
                            navigationIcon = {
                                IconButton(
                                    content = {
                                        Icon(
                                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_arrow_back_24),
                                            contentDescription = "back arrow"
                                        )
                                    },
                                    onClick = {
                                        onBackPressed()
                                    }
                                )
                            }
                        )


                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color.Gray
                        ) {
                            NotesNavHost()
                        }

                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNotesTheme {
    }
}