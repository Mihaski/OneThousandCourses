package com.example.onethousandcourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.onethousandcourses.presentation.OneNavHost
import com.example.onethousandcourses.ui.theme.OneThousandCoursesTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.refreshCourses()

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            OneThousandCoursesTheme {

                OneNavHost(navController, "main")
            }
        }
    }
}