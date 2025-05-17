package com.example.onethousandcourses.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.onethousandcourses.R

@Preview(widthDp = 200, heightDp = 200)
@Composable
fun ScrollContainer(painter: Painter = painterResource(R.drawable.courses_preview)) {

    Box(
        Modifier
            .horizontalScroll(rememberScrollState())
    ) {
        Image(painter, "Картинка скролящаяся горизонтально")
    }
}