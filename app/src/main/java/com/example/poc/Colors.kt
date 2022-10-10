package com.example.poc

import androidx.compose.ui.graphics.Color

interface Colors {
    val button: Color
    val text: Color
}

data class DataColors(
    override val button: Color,
    override val text: Color
) : Colors



