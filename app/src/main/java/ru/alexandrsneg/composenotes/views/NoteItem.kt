package ru.alexandrsneg.composenotes.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.alexandrsneg.composenotes.navigation.NavRoute
import ru.alexandrsneg.composenotes.ui.theme.ComposeNotesTheme

@Composable
fun NoteItem(navHostController: NavHostController, title: String, body: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clickable {
                navHostController.navigate(NavRoute.NoteScreen.route)
            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = title,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 24.sp
            )
            Text(
                text = body,
                fontSize = 16.sp
            )
        }

    }
}


@Composable
@Preview(showBackground = true)
fun prevNoteItem() {
    ComposeNotesTheme {
        NoteItem(
            navHostController = rememberNavController(),
            title = "Title",
            body = "Some body Some bod Some bod Some bod Some bodSome bod"
        )
    }

}