package com.example.onethousandcourses.presentation

import com.example.onethousandcourses.R

sealed class NavigationItem(val label: String, val iconRes: Int) {
    data object Home : NavigationItem("Главная", R.drawable.home_icon)
    data object Favorites : NavigationItem("Избранное", R.drawable.favorite_icon_bar)
    data object Account : NavigationItem("Аккаунт", R.drawable.account_icon)

    companion object {
        val items = listOf(Home, Favorites, Account)
    }
}