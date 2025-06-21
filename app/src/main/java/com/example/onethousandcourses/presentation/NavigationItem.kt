package com.example.onethousandcourses.presentation

import com.example.domain.Course

sealed class NavigationItem(val label: String = "", val iconRes: Int? = null, val route: String) {

    data class WebView(val link: String) : NavigationItem(route = "web_view/$link") {
        companion object {
            const val ROUTE_WITH_ARGS = "web_view/{link}"
        }
    }

    data class Details(val course: Course) : NavigationItem(route = "details/$course") {
        companion object {
            const val ROUTE_WITH_ARGS = "details/{course}"
        }
    }

    data object OnBoarding : NavigationItem(route = "on_boarding")

    data object SignIn : NavigationItem(route = "sing_in")


}