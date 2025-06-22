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
                MainScreen(navController = navHostController)
            }
            composable("account") {
                AccountScreen()
            }
            composable("favorites") { FavoriteScreen(navController = navHostController) }

            composable(
                route = NavigationItem.Details.ROUTE_WITH_ARGS,
                arguments = listOf(
                    navArgument("rate") { type = NavType.StringType },
                    navArgument("startDate") { type = NavType.StringType },
                    navArgument("title") { type = NavType.StringType },
                    navArgument("textDescription") { type = NavType.StringType },
                    navArgument("hasLike") { type = NavType.BoolType },
                    navArgument("courseId") { type = NavType.IntType }
                )) { backStackEntry ->
                val courseId = backStackEntry.arguments?.getInt("courseId") ?: 0
                val rate = backStackEntry.arguments?.getString("rate") ?: ""
                val startDate = backStackEntry.arguments?.getString("startDate") ?: ""
                val title = backStackEntry.arguments?.getString("title") ?: ""
                val textDescription = backStackEntry.arguments?.getString("textDescription") ?: ""
                val hasLike = backStackEntry.arguments?.getBoolean("hasLike") ?: false

                DetailsScreen(
                    courseId = courseId,
                    rate = rate,
                    startDate = startDate,
                    title = title,
                    textDescription = textDescription,
                    hasLike = hasLike,
                    navController = navHostController
                )
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