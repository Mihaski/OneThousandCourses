package com.example.onethousandcourses.presentation.screens

import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Preview(showBackground = true)
@Composable
fun WebViewScreen(
    modifier: Modifier = Modifier,
    link: String = "<!DOCTYPE html><html><head><style>html, body { margin: 0; padding: 0; height: 100%; }</style></head><body><div style='height: 100%; background-color: green;'></div></body><html>",
) {

    Box(modifier = modifier.fillMaxSize()) {

        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }, update = {
            it.loadUrl(link)
        })
    }
}