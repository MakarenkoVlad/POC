package com.example.poc.v1

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.poc.Brand
import com.example.poc.brand1DarkColors
import com.example.poc.brand1LightColors
import com.example.poc.brand2Colors

internal val LocalColors = staticCompositionLocalOf { brand1DarkColors }

enum class IsDarkThemeType {
    SYSTEM {
        override val isDark: Boolean
            @Composable
            @ReadOnlyComposable
            get() = isSystemInDarkTheme()

    },
    FORCE_DARK {
        override val isDark: Boolean
            @Composable
            @ReadOnlyComposable
            @NonRestartableComposable
            get() = true
    },
    FORCE_LIGHT {
        override val isDark: Boolean
            @Composable
            @ReadOnlyComposable
            @NonRestartableComposable
            get() = false
    };

    abstract val isDark: Boolean
        @Composable
        @ReadOnlyComposable
        get
}

// V1
interface ColorTokens {

    val color: Color

    companion object
}

val ColorTokens.Companion.BUTTON: ColorTokens
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current.button

val ColorTokens.Companion.TEXT: ColorTokens
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current.text

//

//V2

interface ColorTokens2 {

    val color: Color

    companion object {
        val BUTTON: ColorTokens
            @Composable
            @ReadOnlyComposable
            get() = LocalColors.current.button

        val TEXT: ColorTokens
            @Composable
            @ReadOnlyComposable
            get() = LocalColors.current.text
    }
}

//

@Composable
fun Theme(isDarkThemeType: IsDarkThemeType, brand: Brand, content: @Composable () -> Unit) {

    val currentColors = when (brand) {
        Brand.BRAND1 -> if (isDarkThemeType.isDark) {
            brand1DarkColors
        } else {
            brand1LightColors
        }
        Brand.BRAND2 -> brand2Colors
    }

    CompositionLocalProvider(
        LocalColors provides currentColors,
        content = content
    )
}