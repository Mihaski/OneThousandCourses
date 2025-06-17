package com.example.onethousandcourses.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.onethousandcourses.R

@Preview
@Composable
fun DetailsScreen(modifier: Modifier = Modifier) {

    Column(modifier.verticalScroll(rememberScrollState())) {

        Image(
            painterResource(R.drawable.picture_details),
            contentDescription = "top picture container"
        )
    }
}