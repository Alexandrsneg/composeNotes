package ru.alexandrsneg.composenotes.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.alexandrsneg.composenotes.navigation.NavRoute
import ru.alexandrsneg.composenotes.views.NoteItem

@Composable
fun MainScreen(navHostController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate(route = NavRoute.AddScreen.route)
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "add item",
                    tint = Color.White
                )
            }
        }
    ) {
        Column {
            NoteItem(navHostController = navHostController, title = "Title 1", body = "Body 1 Body 1 Body 1 Body 1")
            NoteItem(navHostController = navHostController, title = "Title 2", body = "Body 1 Body 1 Body 1 Body 1")
            NoteItem(navHostController = navHostController, title = "Title 3", body = "Body 1 Body 1 Body 1 Body 1")
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PrevMainScreen() {
    MainScreen(navHostController = rememberNavController())

}