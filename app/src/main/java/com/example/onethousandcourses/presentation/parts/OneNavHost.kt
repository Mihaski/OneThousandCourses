package com.example.onethousandcourses.presentation.parts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.onethousandcourses.presentation.BottomNavItems
import com.example.onethousandcourses.presentation.NavigationItem
import com.example.onethousandcourses.presentation.screens.AccountScreen
import com.example.onethousandcourses.presentation.screens.DetailsScreen
import com.example.onethousandcourses.presentation.screens.FavoriteScreen
import com.example.onethousandcourses.presentation.screens.MainScreen
import com.example.onethousandcourses.presentation.screens.OnBoardingScreen
import com.example.onethousandcourses.presentation.screens.SignInScreen
import com.example.onethousandcourses.presentation.screens.WebViewScreen

@Composable
fun OneNavHost(
    navHostController: NavHostController,
    startDestination: String,
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    println("Current destination route: $currentDestination")

    val bottomBarScreens = BottomNavItems.navigationBarItems.map {
        it.route
    }
    val shouldShowBottomBar = currentDestination?.route in bottomBarScreens

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                CourseNavigationBar(
                    navHostController = navHostController,
                    startDestination = startDestination
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavigationItem.OnBoarding.route) {
                OnBoardingScreen(navController = navHostController)
            }
            composable(NavigationItem.SignIn.route) {
                SignInScreen(navController = navHostController)
            }
            composable("main") {
                MainScreen()
            }
            composable("account") {
                AccountScreen()
            }
            composable("favorites") { FavoriteScreen() }

            composable("details/{course}") { backStackEntry ->
//                val courseId = backStackEntry.arguments?.getString("course")?.toIntOrNull()
//                courseId?.let { DetailsScreen() }
            }
            composable(
                route = NavigationItem.WebView.ROUTE_WITH_ARGS,
                arguments = listOf(navArgument("link") { type = NavType.StringType })
            ) { navBackStackEntry ->
//                val args = navBackStackEntry.toRoute<NavigationItem.WebView>()
                val args = navBackStackEntry.arguments?.getString("link") ?: ""
                WebViewScreen(link = args)
            }
        }
    }
}