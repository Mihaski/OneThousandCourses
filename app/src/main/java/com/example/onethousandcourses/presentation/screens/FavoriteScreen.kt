package com.example.onethousandcourses.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onethousandcourses.MainViewModel
import com.example.onethousandcourses.presentation.parts.ItemCourse
import com.example.onethousandcourses.ui.theme.appStyle

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val courses by viewModel.uiState.collectAsState()

    val favorites = courses.filter {
        it.hasLike
    }

    val listState = rememberLazyListState()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(all = 16.dp)
    ) {
        Text("Избранное", style = appStyle, fontSize = 20.sp)

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = listState
        ) {
            items(
                items = favorites,
                key = { it.id }
            ) { item ->
                ItemCourse(
                    navController = navController,
                    rate = item.rate,
                    startDate = item.startDate,
                    hasLike = item.hasLike,
                    title = item.title,
                    textDescription = item.text
                )

            }
        }
    }
}