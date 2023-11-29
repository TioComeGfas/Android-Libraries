package cl.tiocomegfas.lib.uicompose.typography.style

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import cl.tiocomegfas.lib.uicompose.color.AndroidColorFactory
import cl.tiocomegfas.lib.uicompose.size.Size
import cl.tiocomegfas.lib.uicompose.typography.font.AndroidFont

internal class TitleAndroidStyle: AndroidStyle {
    override fun getLarge(font: AndroidFont): TextStyle {
        return TextStyle(
            fontSize = Size.SIZE_40.toSp(),
            lineHeight = Size.SIZE_56.toSp(),
            fontFamily = font.getFontFamily(),
            fontWeight = FontWeight.W400,
            color = AndroidColorFactory.createBlack().get5Percent()
        )
    }

    override fun getMedium(font: AndroidFont): TextStyle {
        TODO("Not yet implemented")
    }

    override fun getSmall(font: AndroidFont): TextStyle {
        TODO("Not yet implemented")
    }

    override fun getExtraSmall(font: AndroidFont): TextStyle {
        TODO("Not yet implemented")
    }
}