package cl.tiocomegfas.lib.uicompose.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun UiKitTheme(
    content: @Composable () -> Unit
) {
    val isDarkMode = isSystemInDarkTheme()
    val colorScheme = when(isDarkMode) {
        true -> UiKitInstance.theme.createDarkColor()
        false -> UiKitInstance.theme.createLightColor()
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = isDarkMode
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = UiKitInstance.theme.createTypography(),
        content = content
    )
}