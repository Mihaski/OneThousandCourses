package com.example.onethousandcourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.compose.rememberNavController
import com.example.onethousandcourses.presentation.parts.OneNavHost
import com.example.onethousandcourses.ui.theme.OneThousandCoursesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.uiState.asLiveData()
        //todo tut nado obnovit repository

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            OneThousandCoursesTheme {

                OneNavHost(navController, "main")
            }
        }
    }
}