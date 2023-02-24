package ru.alexandrsneg.composenotes.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.alexandrsneg.composenotes.ui.theme.ComposeNotesTheme

@Composable
fun AddScreen(navHostController: NavHostController) {
    var title: String by rememberSaveable { mutableStateOf("") }
    var body: String by rememberSaveable { mutableStateOf("") }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Add note", modifier = Modifier.padding(vertical = 4.dp))
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "Add title") },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = body,
                onValueChange = { body = it },
                label = { Text(text = "Add description") },
                singleLine = false,
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    Log.d("IVANOV", title)
                    Log.d("IVANOV", body)
                }
            ) {
                Text(text = "Save")
            }
        }
    }
}


@Composable
@Preview
fun PrevAddScreen() {
    ComposeNotesTheme() {
        AddScreen(navHostController = rememberNavController())
    }
}