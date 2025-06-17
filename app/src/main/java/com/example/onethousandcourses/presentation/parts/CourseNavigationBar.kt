package com.example.onethousandcourses.presentation.parts

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.onethousandcourses.presentation.NavigationItem
import com.example.onethousandcourses.ui.theme.green
import com.example.onethousandcourses.ui.theme.greyCard
import com.example.onethousandcourses.ui.theme.indicatorColor
import com.example.onethousandcourses.ui.theme.textWhite

@Preview
@Composable
fun CourseNavigationBar(modifier: Modifier = Modifier) {

    var selectedItemIndex by remember { mutableIntStateOf(0) }

    NavigationBar(
        modifier = modifier,
        containerColor = greyCard
    ) {
        NavigationItem.items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { selectedItemIndex = index },
                icon = {
                    Icon(
                        painterResource(item.iconRes),
                        contentDescription = item.label
                    )
                },
                label = { Text(item.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = green,
                    unselectedIconColor = textWhite,
                    selectedTextColor = green,
                    unselectedTextColor = textWhite,
                    indicatorColor = indicatorColor
                )
            )
        }
    }
}