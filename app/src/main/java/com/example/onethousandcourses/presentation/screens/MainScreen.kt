package com.example.onethousandcourses.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.onethousandcourses.MainViewModel
import com.example.onethousandcourses.R
import com.example.onethousandcourses.presentation.parts.ItemCourse
import com.example.onethousandcourses.ui.theme.appStyle
import com.example.onethousandcourses.ui.theme.green
import com.example.onethousandcourses.ui.theme.grey
import com.example.onethousandcourses.ui.theme.hintTextGrey
import com.example.onethousandcourses.ui.theme.textWhite

@Preview
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val courses by viewModel.uiState.collectAsState()

    val listState = rememberLazyListState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(all = 16.dp)
    ) {

//top search container
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
//left part row
            var textSearchField by remember {
                mutableStateOf(TextFieldValue(""))
            }
            TextField(
                value = textSearchField,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = grey,
                    focusedContainerColor = grey,
                    unfocusedPlaceholderColor = hintTextGrey,
                    focusedPlaceholderColor = hintTextGrey,
                    unfocusedTextColor = textWhite,
                    focusedTextColor = textWhite
                ),
                shape = CircleShape,
                placeholder = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier
                                .padding(all = 8.dp)
                                .scale(1.5f)
                                .padding(end = 4.dp),
                            painter = painterResource(R.drawable.search_icon),
                            contentDescription = "search icon",
                            tint = textWhite
                        )
                        Text("Search courses...", fontSize = 18.sp)
                    }
                },
                onValueChange = { newInput -> textSearchField = newInput }
            )
//belay
            Spacer(Modifier.padding(1.dp))
//right part of row
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(71.dp)
                    .clip(CircleShape)
                    .background(grey)
            ) {
                Icon(
                    modifier = Modifier.scale(1.5f),
                    painter = painterResource(R.drawable.funnel_icon),
                    contentDescription = "funnel icon",
                    tint = textWhite
                )
            }
        }

//sort section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
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
                items = courses,
                key = { it.id }
            ) { item ->
                ItemCourse(
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