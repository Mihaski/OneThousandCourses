package com.example.onethousandcourses.presentation.parts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onethousandcourses.R
import com.example.onethousandcourses.ui.theme.grey
import com.example.onethousandcourses.ui.theme.hintTextGrey
import com.example.onethousandcourses.ui.theme.normalStyle
import com.example.onethousandcourses.ui.theme.textWhite

@Preview(showBackground = true)
@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    dimensions:Int = 56,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // left bubble
        var textSearchField by remember {
            mutableStateOf(TextFieldValue(""))
        }
        TextField(
            modifier = Modifier
                .weight(1f)
                .height(dimensions.dp),
            textStyle = normalStyle,
            value = textSearchField,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = grey,
                focusedContainerColor = grey,
                unfocusedPlaceholderColor = hintTextGrey,
                focusedPlaceholderColor = hintTextGrey,
                unfocusedTextColor = textWhite,
                focusedTextColor = textWhite
            ),
            shape = CircleShape,
            placeholder = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.padding(end = 19.dp),
                        painter = painterResource(R.drawable.search_icon_main_screen),
                        contentDescription = "search icon",
                        tint = textWhite
                    )
                    Text("Search courses...", fontSize = 18.sp)
                }
            },
            onValueChange = { newInput -> textSearchField = newInput }
        )

//right part of row
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .size(dimensions.dp)
                .background(grey)
        ) {
            Icon(
                modifier = Modifier,
                painter = painterResource(R.drawable.funnel_icon),
                contentDescription = "funnel icon",
                tint = textWhite
            )
        }
    }
}
