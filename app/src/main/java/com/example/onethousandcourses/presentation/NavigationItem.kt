package com.example.onethousandcourses.presentation

sealed class NavigationItem(val label: String = "", val iconRes: Int? = null, val route: String) {

    data class WebView(val link: String) : NavigationItem(route = "web_view/$link") {
        companion object {
            const val ROUTE_WITH_ARGS = "web_view/{link}"
        }
    }

    data class Details(
        val courseId: Int,
        val rate: String,
        val startDate: String,
        val title: String,
        val textDescription: String,
        val hasLike: Boolean,
    ) : NavigationItem(
        route = "details/$rate/$startDate/$title/$textDescription/$hasLike/$courseId"
    ) {
        companion object {
            const val ROUTE_WITH_ARGS =
                "details/{rate}/{startDate}/{title}/{textDescription}/{hasLike}/{courseId}"
        }
    }

    data object OnBoarding : NavigationItem(route = "on_boarding")

    data object SignIn : NavigationItem(route = "sing_in")


}