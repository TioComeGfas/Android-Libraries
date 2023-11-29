package cl.tiocomegfas.lib.uicompose.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cl.tiocomegfas.lib.uicompose.size.Size

@Composable
fun VerticalSpacerExtraSmall() {
    Spacer(
        modifier = Modifier.width(Size.SIZE_32.toDp())
    )
}