package com.example.onethousandcourses.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onethousandcourses.R
import com.example.onethousandcourses.ui.theme.appStyle
import com.example.onethousandcourses.ui.theme.glass
import com.example.onethousandcourses.ui.theme.green
import com.example.onethousandcourses.ui.theme.greyCard
import com.example.onethousandcourses.ui.theme.hintTextGrey
import com.example.onethousandcourses.ui.theme.textWhite

@Preview
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    rate: String = "4.9",
    startDate: String = "22 мая 2024",
    title: String = "Java-разработчик с нуля",
    textDescription: String = "Освойте backend-разработку \nи программирование на Java" +
            ", фреймворки Spring и Maven, работу с базами данных и API. Создайте" +
            " свой собственный проект, собрав портфолио и став востребованным" +
            " специалистом для любой IT компании.",
    hasLike: Boolean = false,
) {

    var selectHasLike by remember { mutableStateOf(hasLike) }

    Box(modifier = modifier) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
        ) {
//container with image, rate and date
            Box {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(R.drawable.picture_details),
                    contentDescription = "top picture container",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillWidth
                )
//rate and date
                Row(
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                ) {

//rate bubble
                    Box(
                        modifier = modifier
                            .clip(CircleShape)
                            .background(glass)
                            .padding(vertical = 4.dp, horizontal = 6.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                tint = green,
                                contentDescription = "",
                                painter = painterResource(R.drawable.star_fill)
                            )
                            Text(text = rate, Modifier.padding(start = 5.dp), style = appStyle)
                        }
                    }
//date bubble
                    Box(
                        modifier = modifier
                            .padding(start = 6.dp)
                            .clip(CircleShape)
                            .background(glass)
                            .padding(vertical = 4.dp, horizontal = 6.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = startDate, style = appStyle)
                        }
                    }
                }
            }
//container with text and buttons
            Column(Modifier.padding(all = 16.dp)) {
                Text(
                    text = title,
                    style = appStyle,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(R.drawable.image_author_details),
                        contentDescription = "picture against author text"
                    )

                    Column(
                        Modifier
                            .padding(vertical = 4.dp)
                            .padding(start = 12.dp)
                    ) {
                        Text(
                            "Автор",
                            fontSize = 14.sp,
                            style = appStyle,
                            color = hintTextGrey,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "Merion Academy",
                            style = appStyle,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    colors = ButtonDefaults.buttonColors(green)
                ) {
                    Text("Начать курс", style = appStyle, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 28.dp),
                    colors = ButtonDefaults.buttonColors(greyCard)
                ) {
                    Text("Перейти на платформу", style = appStyle, fontWeight = FontWeight.Bold)
                }

                Text(
                    text = "О курсе",
                    style = appStyle,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Text(
                    text = textDescription,
                    fontSize = 15.sp,
                    style = appStyle,
                    color = hintTextGrey
                )
            }
        }

        //White Button with arrow
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 56.dp, start = 16.dp)
                .size(44.dp)
                .clip(CircleShape)
                .background(textWhite)
                .clickable(onClick = { })
        ) {
            Icon(
                painterResource(R.drawable.back_arrow),
                contentDescription = "popBackStack",
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 56.dp, end = 16.dp)
                .align(Alignment.TopEnd)
                .size(44.dp)
                .clip(CircleShape)
                .background(textWhite)
                .clickable(onClick = { selectHasLike = !selectHasLike })
        ) {
            val iconRes =
                if (selectHasLike) R.drawable.fill_favourite_icon_bar_details
                else R.drawable.favorite_icon_bar_details
            Icon(
                painterResource(iconRes),
                tint = if (selectHasLike) green else Color.Black,
                contentDescription = "popBackStack",
            )
        }
    }
}