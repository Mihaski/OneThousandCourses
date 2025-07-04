package com.example.onethousandcourses.presentation.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.onethousandcourses.MainViewModel
import com.example.onethousandcourses.R
import com.example.onethousandcourses.presentation.NavigationItem
import com.example.onethousandcourses.ui.theme.appStyle
import com.example.onethousandcourses.ui.theme.glass
import com.example.onethousandcourses.ui.theme.green
import com.example.onethousandcourses.ui.theme.greyCard
import com.example.onethousandcourses.ui.theme.hintTextGrey
import com.example.onethousandcourses.ui.theme.textWhite

@Composable
fun ItemCourse(
    modifier: Modifier = Modifier,
    navController: NavController,
    courseId: Int,
    rate: String = "4.9",
    startDate: String = "22 мая 2024",
    hasLike: Boolean = false,
    title: String = "Java-разработчик с нуля",
    textDescription: String = "Освойте backend-разработку \nи программирование на Java" +
            ", фреймворки Spring и Maven, работу с базами данных и API. Создайте" +
            " свой собственный проект, собрав портфолио и став востребованным" +
            " специалистом для любой IT компании.",
    price: String = "999",
    viewModel: MainViewModel = hiltViewModel(),
) {
    var selectHasLike by remember { mutableStateOf(hasLike) }

    Card(
        colors = CardDefaults.cardColors(greyCard),
        modifier = modifier
            .fillMaxWidth()
    ) {
        // top container with image
        Box {
            Image(
                contentDescription = "",
                painter = painterResource(R.drawable.card_picture),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
                    .clip(CircleShape)
                    .background(glass)
                    .clickable(onClick = {
                        viewModel.toggleLike(courseId = courseId)
                        selectHasLike = !selectHasLike
                    })
                    .padding(vertical = 8.dp, horizontal = 9.dp)
            ) {
                val iconRes =
                    if (selectHasLike) R.drawable.fill_has_favorite_icon_item
                    else R.drawable.has_favorite_icon_item
                Icon(
                    painter = painterResource(iconRes),
                    tint = if (selectHasLike) green else textWhite,
                    contentDescription = "has like switcher"
                )
            }
            Row(
                Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
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
        // bottom container
        Column(Modifier.padding(all = 16.dp)) {
            Text(text = title, style = appStyle)
            Text(
                text = textDescription,
                modifier = Modifier.padding(top = 12.dp),
                style = appStyle,
                color = hintTextGrey,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("$price ₽", style = appStyle)
                Row(
                    modifier = Modifier.clickable {
                        navController.navigate(
                            NavigationItem.Details(
                                rate = rate,
                                startDate = startDate,
                                title = title,
                                textDescription = textDescription,
                                hasLike = hasLike,
                                courseId = courseId
                            ).route
                        )
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Подробнее", style = appStyle, color = green)
                    Icon(
                        tint = green,
                        contentDescription = "",
                        painter = painterResource(R.drawable.arrow_right_short_fill)
                    )
                }
            }
        }
    }
}