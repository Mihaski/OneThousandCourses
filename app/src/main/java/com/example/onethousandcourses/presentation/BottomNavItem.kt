package com.example.onethousandcourses.presentation

import com.example.onethousandcourses.R

data class BottomNavItem(val label: String, val iconRes: Int, val route: String)

object BottomNavItems {
    val navigationBarItems = listOf(
        BottomNavItem("Главная", R.drawable.main_icon_home, "main"),
        BottomNavItem("Избранное", R.drawable.favorite_icon_bar_details, "favorites"),
        BottomNavItem("Аккаунт", R.drawable.account_icon, "account"),
    )
}