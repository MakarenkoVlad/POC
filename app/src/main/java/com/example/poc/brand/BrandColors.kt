package com.example.poc.brand

import androidx.compose.ui.graphics.Color
import com.example.poc.DataColors

enum class Brand {
    BRAND1, BRAND2;
}

val brand1LightColors = DataColors(
    Color.LightGray,
    Color.Green
)

val brand1DarkColors = DataColors(
    Color.Gray,
    Color.White
)

val brand2Colors = DataColors(
    Color.Cyan,
    Color.White
)