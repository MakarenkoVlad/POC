package com.example.poc

import androidx.compose.ui.graphics.Color
import com.example.poc.v1.ColorTokens

data class Colors(
    val button: ColorTokens,
    val text: ColorTokens
)

enum class Brand {
    BRAND1, BRAND2;
}

val brand1LightColors = Colors(
    Color.LightGray.asColorToken(),
    Color.Green.asColorToken()
)

val brand1DarkColors = Colors(
    Color.Gray.asColorToken(),
    Color.White.asColorToken()
)

val brand2Colors = Colors(
    Color.Cyan.asColorToken(),
    Color.White.asColorToken()
)

private fun Color.asColorToken() = object : ColorTokens {
    override val color: Color
        get() = this@asColorToken
}