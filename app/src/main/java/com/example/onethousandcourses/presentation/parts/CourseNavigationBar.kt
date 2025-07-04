package com.example.onethousandcourses.presentation.parts

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.onethousandcourses.presentation.BottomNavItems
import com.example.onethousandcourses.ui.theme.green
import com.example.onethousandcourses.ui.theme.greyCard
import com.example.onethousandcourses.ui.theme.indicatorColor
import com.example.onethousandcourses.ui.theme.textWhite

@Composable
fun CourseNavigationBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String,
) {
    val navBackStackEntry = navHostController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route ?: return

    NavigationBar(
        modifier = modifier,
        containerColor = greyCard
    ) {
        BottomNavItems.navigationBarItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navHostController.navigate(item.route) {
                            popUpTo(startDestination) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painterResource(item.iconRes),
                        contentDescription = item.label
                    )
                },
                label = { Text(item.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = green,
                    unselectedIconColor = textWhite,
                    selectedTextColor = green,
                    unselectedTextColor = textWhite,
                    indicatorColor = indicatorColor
                )
            )
        }
    }
}