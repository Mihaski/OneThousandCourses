package com.example.onethousandcourses.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onethousandcourses.R
import com.example.onethousandcourses.ui.theme.appStyle
import com.example.onethousandcourses.ui.theme.green
import com.example.onethousandcourses.ui.theme.grey
import com.example.onethousandcourses.ui.theme.hintTextGrey
import com.example.onethousandcourses.ui.theme.strokeColor
import com.example.onethousandcourses.ui.theme.textWhite

@Preview(showBackground = true, backgroundColor = 0)
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Column(
        modifier = modifier
            .background(Color.Black)
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Вход",
            Modifier
                .align(Alignment.Start)
                .padding(bottom = 20.dp),
            style = appStyle,
            fontSize = 30.sp
        )

        Text(
            "Email",
            Modifier
                .align(Alignment.Start)
                .padding(bottom = 15.dp),
            style = appStyle,
            fontSize = 18.sp
        )

        var textEmail by remember {
            mutableStateOf(TextFieldValue(""))
        }
        TextField(
            textEmail,
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = grey,
                focusedContainerColor = grey,
                unfocusedPlaceholderColor = hintTextGrey,
                focusedPlaceholderColor = hintTextGrey,
                unfocusedTextColor = textWhite,
                focusedTextColor = textWhite
            ),
            onValueChange = {
                    newInput ->
                textEmail = newInput
            },
            placeholder = { Text("example@gmail.com") })

        Text(
            "Пароль", Modifier
                .align(Alignment.Start)
                .padding(bottom = 15.dp), style = appStyle
        )

        var textPassword by remember {
            mutableStateOf(TextFieldValue(""))
        }
        TextField(
            textPassword,
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = grey,
                focusedContainerColor = grey,
                unfocusedPlaceholderColor = hintTextGrey,
                focusedPlaceholderColor = hintTextGrey,
                unfocusedTextColor = textWhite,
                focusedTextColor = textWhite
            ),
            onValueChange = { newInput ->
                textPassword = newInput
            },
            placeholder = { Text("Введите пароль") }
        )

        Button(
            onClick,
            Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
            colors = ButtonDefaults.buttonColors(green)
        ) {
            Text("Вход", fontSize = 16.sp)
        }

        Row(Modifier.padding(bottom = 10.dp)) {
            Text("Нету аккаунта?", style = appStyle)
            Text("Региcтрация", Modifier.padding(start = 5.dp), style = appStyle, color = green)
        }
        Text("Забыл пароль", Modifier.padding(bottom = 65.dp), style = appStyle, color = green)
        Box(
            Modifier
                .padding(bottom = 45.dp)
                .clip(CircleShape)
                .background(strokeColor)
                .fillMaxWidth()
                .height(2.dp)
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick,
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .paint(
                        painter = painterResource(R.drawable.buttonvk),
                        contentScale = ContentScale.FillBounds
                    )
                    .width(175.dp)
            ) { }
            Button(
                onClick,
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .paint(
                        painter = painterResource(R.drawable.buttonok),
                        contentScale = ContentScale.FillBounds
                    )
                    .width(175.dp)
            ) { }
        }


    }
}