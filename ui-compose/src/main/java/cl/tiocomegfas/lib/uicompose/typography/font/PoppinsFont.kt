package cl.tiocomegfas.lib.uicompose.typography.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import cl.tiocomegfas.lib.uicompose.R

internal class PoppinsFont: AndroidFont {
    override fun getThin(): Font {
        return Font(resId = R.font.poppins_thin, weight = FontWeight.Thin, style = FontStyle.Normal, loadingStrategy = FontLoadingStrategy.Blocking)
    }

    override fun getLight(): Font {
        return Font(resId = R.font.poppins_light, weight = FontWeight.Thin, style = FontStyle.Normal, loadingStrategy = FontLoadingStrategy.Blocking)
    }

    override fun getRegular(): Font {
        return Font(resId = R.font.poppins_regular, weight = FontWeight.Thin, style = FontStyle.Normal, loadingStrategy = FontLoadingStrategy.Blocking)
    }

    override fun getMedium(): Font {
        return Font(resId = R.font.poppins_medium, weight = FontWeight.Thin, style = FontStyle.Normal, loadingStrategy = FontLoadingStrategy.Blocking)
    }

    override fun getSemiBold(): Font {
        return Font(resId = R.font.poppins_semi_bold, weight = FontWeight.Thin, style = FontStyle.Normal, loadingStrategy = FontLoadingStrategy.Blocking)
    }

    override fun getBold(): Font {
        return Font(resId = R.font.poppins_bold, weight = FontWeight.Thin, style = FontStyle.Normal, loadingStrategy = FontLoadingStrategy.Blocking)
    }

    override fun getFontFamily(): FontFamily {
        return FontFamily(
            listOf(
                getThin(),
                getRegular(),
                getMedium(),
                getSemiBold(),
                getBold(),
            )
        )
    }
}