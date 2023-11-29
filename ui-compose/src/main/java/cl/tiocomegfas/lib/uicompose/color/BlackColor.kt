package cl.tiocomegfas.lib.uicompose.color

import androidx.compose.ui.graphics.Color

internal class BlackColor: AndroidColor {
    override fun get5Percent(): Color {
        return Color(0xFF000000)
    }

    override fun get10Percent(): Color {
        return Color(0x1A000000)
    }

    override fun get20Percent(): Color {
        return Color(0x33000000)
    }

    override fun get30Percent(): Color {
        return Color(0x4D000000)
    }

    override fun get40Percent(): Color {
        return Color(0x66000000)
    }

    override fun get50Percent(): Color {
        return Color(0x80000000)
    }

    override fun get60Percent(): Color {
        return Color(0x99000000)
    }

    override fun get70Percent(): Color {
        return Color(0xB3000000)
    }

    override fun get80Percent(): Color {
        return Color(0xCC000000)
    }

    override fun get90Percent(): Color {
        return Color(0xE6000000)
    }
}