package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movies.MainViewModel
import com.example.movies.screens.MainScreen
import com.example.movies.screens.SplashScreen
import com.example.movies.utils.Constants


sealed class Screens(val route: String) {
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController,viewModel)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController,viewModel)
        }
        composable(route = Screens.Details.route) {

        }
    }
}