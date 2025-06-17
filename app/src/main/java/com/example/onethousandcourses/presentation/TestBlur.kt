package com.example.onethousandcourses.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onethousandcourses.ui.theme.grey
import com.example.onethousandcourses.ui.theme.textWhite

@Preview(showBackground = true, backgroundColor = 1111111)
@Composable
fun TestBlur() {
    Surface(
        color = Color(0xAA000000),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .width(100.dp)
            .padding(8.dp)
            .blur(5.dp)
    ) {
        Text("112233", color = grey)
    }
    Surface(
        color = Color(0x00000000),
        modifier = Modifier
            .padding(top = 10.dp)
            .width(100.dp)
            .padding(8.dp)
    ) {
        Text("112233", color = textWhite)
    }

}