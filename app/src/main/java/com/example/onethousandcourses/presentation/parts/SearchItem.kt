package com.example.onethousandcourses.presentation.parts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchItem(
    query: String,
    onQueryChange: (String) -> Unit,
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Поле ввода с иконкой поиска
        Row(
            modifier = Modifier
                .weight(1f)
                .background(color = Color(0xFF1C1C1E), shape = RoundedCornerShape(28.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = query,
                onValueChange = onQueryChange,
                placeholder = { Text("Search courses...", color = Color.Gray) },
                colors = TextFieldDefaults.colors(
                ),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                singleLine = true
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Кнопка фильтра
        IconButton(
            onClick = onFilterClick,
            modifier = Modifier
                .size(48.dp)
                .background(color = Color(0xFF1C1C1E), shape = CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Filter Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
