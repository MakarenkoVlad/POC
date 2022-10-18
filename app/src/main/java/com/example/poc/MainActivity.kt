package com.example.poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.poc.v1.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            /**
             * Temp values, in real applications shoud use shared prefs
             */
            var isDarkThemeType by remember {
                mutableStateOf(IsDarkThemeType.SYSTEM)
            }
            var brand by remember { mutableStateOf(Brand.BRAND1) }

            Theme(isDarkThemeType, brand) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.fillMaxSize()) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Button(
                                text = "System",
                                onClick = { isDarkThemeType = IsDarkThemeType.SYSTEM },
                                isSelected = isDarkThemeType == IsDarkThemeType.SYSTEM,
                                modifier = Modifier.weight(1f)
                            )

                            Button(
                                text = "Force dark",
                                onClick = { isDarkThemeType = IsDarkThemeType.FORCE_DARK },
                                isSelected = isDarkThemeType == IsDarkThemeType.FORCE_DARK,
                                modifier = Modifier.weight(1f)
                            )

                            Button(
                                text = "Force light",
                                onClick = { isDarkThemeType = IsDarkThemeType.FORCE_LIGHT },
                                isSelected = isDarkThemeType == IsDarkThemeType.FORCE_LIGHT,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Button(
                                text = "Brand1",
                                onClick = { brand = Brand.BRAND1 },
                                isSelected = brand == Brand.BRAND1,
                                modifier = Modifier.weight(1f)
                            )

                            Button(
                                text = "Brand2",
                                onClick = { brand = Brand.BRAND2 },
                                isSelected = brand == Brand.BRAND2,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Button(text: String, onClick: () -> Unit, isSelected: Boolean, modifier: Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = ColorTokens.BUTTON.color),
        modifier = modifier.height(50.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            AnimatedVisibility(visible = isSelected) {
                Icon(Icons.Default.Check, contentDescription = null, tint = ColorTokens.TEXT.color)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = text, color = ColorTokens.TEXT.color)
        }
    }
}