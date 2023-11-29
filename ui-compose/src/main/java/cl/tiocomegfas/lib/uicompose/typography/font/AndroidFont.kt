package cl.tiocomegfas.lib.uicompose.typography.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

interface AndroidFont {
    fun getThin(): Font
    fun getLight(): Font
    fun getRegular(): Font
    fun getMedium(): Font
    fun getSemiBold(): Font
    fun getBold(): Font
    fun getFontFamily(): FontFamily
}