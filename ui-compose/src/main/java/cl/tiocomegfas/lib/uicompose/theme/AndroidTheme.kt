package cl.tiocomegfas.lib.uicompose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import cl.tiocomegfas.lib.uicompose.typography.font.AndroidFont

interface AndroidTheme {
    fun createDarkColor(): ColorScheme
    fun createLightColor(): ColorScheme
    fun createTypography(): Typography
    fun createFont(): AndroidFont
}