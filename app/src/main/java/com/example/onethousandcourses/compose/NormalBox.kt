package com.example.onethousandcourses.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onethousandcourses.ui.theme.backgroundColorCardGrey
import com.example.onethousandcourses.ui.theme.textColorOvalCard

@Preview
@Composable
fun NormalBox(
    modifier: Modifier = Modifier,
    text: String = "1С Администрирование",
) {

    Box(
        modifier = modifier
            .padding(2.dp)
            .height(45.dp)
            .background(
                shape = CircleShape,
                color = backgroundColorCardGrey
            )
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = textColorOvalCard
        )
    }
}