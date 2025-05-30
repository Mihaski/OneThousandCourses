package com.example.onethousandcourses.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onethousandcourses.presentation.screens.OnBoardingScreen
import com.example.onethousandcourses.presentation.screens.SignInScreen

@Composable
fun OneNavHost(
    navHostController: NavHostController,
    startDestination: String,
) {

    NavHost(navHostController, startDestination) {
        composable("main") {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                OnBoardingScreen(Modifier.padding(innerPadding), navHostController)
            }
        }
        composable("sign_in") {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                SignInScreen(Modifier
                    .fillMaxSize()
                    .padding(innerPadding))
            }
        }
    }
}
