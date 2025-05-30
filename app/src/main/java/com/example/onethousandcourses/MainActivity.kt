package com.example.onethousandcourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.onethousandcourses.presentation.OneNavHost
import com.example.onethousandcourses.ui.theme.OneThousandCoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            OneThousandCoursesTheme {

                OneNavHost(navController, "main")
            }
        }
    }
}