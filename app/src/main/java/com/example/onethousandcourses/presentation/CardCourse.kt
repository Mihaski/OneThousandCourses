package com.example.onethousandcourses.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onethousandcourses.ui.theme.textWhite

@Preview(showBackground = true)
@Composable
fun CardCourse(
    modifier: Modifier = Modifier,
    text: String = "1С Администрирование",
    rotateAngle: Float = 0f,
    color: CardColors = CardDefaults.cardColors(),
    translationForY: Float = 1f,
) {

    Card(
        colors = color,
        shape = CircleShape,
        modifier = Modifier
            .rotate(rotateAngle)
            .padding(end = 4.dp)
            .graphicsLayer(translationY = translationForY)
    ) {
        Box(
            modifier = modifier
                .height(60.dp)
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text, color = textWhite, fontSize = 19.sp)
        }
    }

}