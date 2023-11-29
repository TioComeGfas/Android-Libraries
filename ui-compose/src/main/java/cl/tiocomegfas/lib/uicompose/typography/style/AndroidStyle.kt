package cl.tiocomegfas.lib.uicompose.typography.style

import androidx.compose.ui.text.TextStyle
import cl.tiocomegfas.lib.uicompose.typography.font.AndroidFont

interface AndroidStyle {
    fun getLarge(font: AndroidFont): TextStyle
    fun getMedium(font: AndroidFont): TextStyle
    fun getSmall(font: AndroidFont): TextStyle
    fun getExtraSmall(font: AndroidFont): TextStyle
}