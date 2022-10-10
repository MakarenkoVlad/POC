package com.example.poc.v1

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import com.example.poc.Colors
import com.example.poc.brand.Brand
import com.example.poc.brand.brand1DarkColors
import com.example.poc.brand.brand1LightColors
import com.example.poc.brand.brand2Colors

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

object Theme {
    val colors: Colors
        @ReadOnlyComposable
        @Composable
        get() = LocalColors.current
}

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