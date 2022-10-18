package com.example.poc

import androidx.compose.ui.graphics.Color

data class Colors(
    val button: Color,
    val text: Color
)

enum class Brand {
    BRAND1, BRAND2;
}

val brand1LightColors = Colors(
    Color.LightGray,
    Color.Green
)

val brand1DarkColors = Colors(
    Color.Gray,
    Color.White
)

val brand2Colors = Colors(
    Color.Cyan,
    Color.White
)
