package cl.tiocomegfas.lib.uicompose.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cl.tiocomegfas.lib.uicompose.measurement.Measurement

@Composable
fun HorizontalSpacerMedium() {
    Spacer(
        modifier = Modifier.height(Measurement.SIZE_40.toDp())
    )
}