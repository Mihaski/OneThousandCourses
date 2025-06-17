package com.example.onethousandcourses.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onethousandcourses.R
import com.example.onethousandcourses.presentation.parts.ScrollContainerHorizontal
import com.example.onethousandcourses.ui.theme.green
import com.example.onethousandcourses.ui.theme.textWhite

@Preview(showBackground = true)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
) {

    Column(
        modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color.Black)
            .padding(top = 140.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(R.string.onboarding_title),
                Modifier.padding(bottom = 30.dp),
                color = textWhite,
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )

            ScrollContainerHorizontal()
        }

        Button(
            { navController.navigate("sign_in") },
            Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(green)
        ) {
            Text(stringResource(R.string.button_continue_onboarding_screen), fontSize = 16.sp)
        }

    }
}