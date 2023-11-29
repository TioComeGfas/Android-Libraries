package cl.tiocomegfas.lib.uicompose.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cl.tiocomegfas.lib.uicompose.size.Size

@Composable
fun HorizontalSpacerLarge() {
    Spacer(
        modifier = Modifier.height(Size.SIZE_48.toDp())
    )
}