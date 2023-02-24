package ru.alexandrsneg.composenotes.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.alexandrsneg.composenotes.ui.theme.ComposeNotesTheme

@Composable
fun NoteScreen(navHostController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
        ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 24.dp, top = 16.dp),
                text = "Title",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 24.sp
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .verticalScroll(
                        state = ScrollState(0)
                    ),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "asfasf afafasf asfassfassf")
            }

        }

    }

}

@Composable
@Preview
fun PrevNoteScreen() {
    ComposeNotesTheme {
        NoteScreen(
            navHostController = rememberNavController()
        )
    }

}