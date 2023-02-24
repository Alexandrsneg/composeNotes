package ru.alexandrsneg.composenotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.alexandrsneg.composenotes.screens.AddScreen
import ru.alexandrsneg.composenotes.screens.MainScreen
import ru.alexandrsneg.composenotes.screens.NoteScreen
import ru.alexandrsneg.composenotes.screens.StartScreen


sealed class NavRoute(val route: String) {
    object StartScreen: NavRoute("start_screen")
    object MainScreen: NavRoute("main_screen")
    object AddScreen: NavRoute("add_screen")
    object NoteScreen: NavRoute("note_screen")
}

@Composable
fun NotesNavHost() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route) { StartScreen(navHostController = navController) }
        composable(NavRoute.MainScreen.route) { MainScreen(navHostController = navController) }
        composable(NavRoute.AddScreen.route) { AddScreen(navHostController = navController) }
        composable(NavRoute.NoteScreen.route) { NoteScreen(navHostController = navController) }
    }
}