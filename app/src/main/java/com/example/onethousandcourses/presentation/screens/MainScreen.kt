package com.example.onethousandcourses.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.onethousandcourses.MainViewModel
import com.example.onethousandcourses.R
import com.example.onethousandcourses.presentation.parts.ItemCourse
import com.example.onethousandcourses.presentation.parts.SearchItem
import com.example.onethousandcourses.ui.theme.appStyle
import com.example.onethousandcourses.ui.theme.green

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController,
) {
    val courses by viewModel.uiState.collectAsState()
    val isSortedDescending = remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    val sortedCourses = if (isSortedDescending.value) {
        courses.sortedByDescending { it.publishDate }
    } else {
        courses
    }

    LaunchedEffect(isSortedDescending.value) {
        listState.scrollToItem(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(all = 16.dp)
    ) {

//top search container
        SearchItem()

//sort section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .clickable {
                    isSortedDescending.value = !isSortedDescending.value
                },
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                "По дате добавления",
                style = appStyle,
                color = green,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(R.drawable.sorted_icon),
                contentDescription = "sorted icon",
                tint = green
            )
        }

//main container
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = listState
        ) {
            items(
                items = sortedCourses,
                key = { it.id }
            ) { item ->
                ItemCourse(
                    courseId = item.id,
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