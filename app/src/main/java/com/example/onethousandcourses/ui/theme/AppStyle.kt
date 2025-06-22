package com.example.onethousandcourses.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.onethousandcourses.R

val appStyle = TextStyle(
    fontFamily = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal)
    ),
    color = Color.White
)

val hintStyle = appStyle.copy(color = Color.Unspecified, fontSize = 18.sp)

val normalStyle = appStyle.copy(fontSize = 20.sp)
val titleStyle = appStyle.copy(fontSize = 30.sp)
val smallStyle = appStyle.copy(fontSize = 18.sp)