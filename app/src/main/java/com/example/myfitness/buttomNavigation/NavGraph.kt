package com.example.myfitness.buttomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController,
        startDestination = "login"){
        composable("login"){
            LoginScreen(navController = navHostController)
        }
        composable("registartion"){
            RegistrationScreen()
        }
        composable("train") {
            TrainScreen()
        }
    }
}