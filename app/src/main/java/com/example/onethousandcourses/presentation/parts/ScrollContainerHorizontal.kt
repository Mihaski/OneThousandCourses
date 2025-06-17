package com.example.onethousandcourses.presentation.parts

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onethousandcourses.ui.theme.green
import com.example.onethousandcourses.ui.theme.backgroundColorCardGrey
import com.example.onethousandcourses.utils.LabelText

@Preview(showBackground = true)
@Composable
fun ScrollContainerHorizontal(modifier: Modifier = Modifier) {

    val textN = LabelText()

    Box(
        Modifier.horizontalScroll(rememberScrollState(200))
    ) {
        Column {

            val rowSettings = Modifier
                .padding(bottom = 4.dp)
                .align(Alignment.CenterHorizontally)

            Row(
                rowSettings
            ) {
                CardCourse(
                    text = textN.s1,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s2, rotateAngle = -15f, color = CardDefaults.cardColors(
                        green
                    ), translationForY = 20f
                )
                CardCourse(
                    text = textN.s3,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
            }

            Row(
                rowSettings.graphicsLayer(translationY = 175f)
            ) {
                CardCourse(
                    text = textN.s7,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s8,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s9,
                    color = CardDefaults.cardColors(green),
                    rotateAngle = 15f,
                    translationForY = -25f
                )
            }

            Row(
                rowSettings.graphicsLayer(translationY = -175f)
            ) {
                CardCourse(
                    text = textN.s4,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s5,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s6,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
            }

            Row(
                rowSettings.graphicsLayer(translationY = 175f)
            ) {
                CardCourse(
                    text = textN.s14,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s15,
                    color = CardDefaults.cardColors(green),
                    rotateAngle = -15f,
                    translationForY = -25f
                )
                CardCourse(
                    text = textN.s16,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s17,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
            }

            Row(
                rowSettings.graphicsLayer(translationY = -175f)
            ) {
                CardCourse(
                    text = textN.s10,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s11,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s12,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )
                CardCourse(
                    text = textN.s13,
                    color = CardDefaults.cardColors(backgroundColorCardGrey)
                )

            }
        }
    }
}