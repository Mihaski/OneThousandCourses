package com.example.onethousandcourses.presentation

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.onethousandcourses.R

@Preview
@Composable
fun TestResources() {
    Icon(
        painter = painterResource(R.drawable.main_icon_home),
        contentDescription = "Home Icon"
    )
}