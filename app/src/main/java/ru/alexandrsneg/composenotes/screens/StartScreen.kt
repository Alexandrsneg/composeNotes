package ru.alexandrsneg.composenotes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.alexandrsneg.composenotes.navigation.NavRoute
import ru.alexandrsneg.composenotes.ui.theme.ComposeNotesTheme

@Composable
fun StartScreen(navHostController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("What we will use?")
            Button(
                onClick = {
                    navHostController.navigate(route = NavRoute.MainScreen.route)
                },
                modifier = Modifier.width(200.dp),
                content = {
                    Text(text = "Room")
                }
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp),
                content = {
                    Text(text = "Fire Base")
                }
            )

        }

    }
}


@Composable
@Preview(showBackground = true)
fun prevStartScreen() {
    ComposeNotesTheme {
        StartScreen(navHostController = rememberNavController())
    }

}