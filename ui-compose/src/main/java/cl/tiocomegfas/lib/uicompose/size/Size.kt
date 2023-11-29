package cl.tiocomegfas.lib.uicompose.size

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class Size(
    private val value: Int
) {
    SIZE_4(4),
    SIZE_8(8),
    SIZE_12(12),
    SIZE_16(16),
    SIZE_24(24),
    SIZE_32(32),
    SIZE_40(40),
    SIZE_48(48),
    SIZE_56(56),
    SIZE_64(64),
    SIZE_96(96),
    SIZE_128(128);

    internal fun toDp(): Dp = this.value.dp
    internal fun toSp(): TextUnit = this.value.sp
}