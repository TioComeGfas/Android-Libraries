package cl.tiocomegfas.lib.uicompose.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import cl.tiocomegfas.lib.uicompose.measurement.Measurement
import cl.tiocomegfas.lib.uicompose.theme.UiKitInstance
import cl.tiocomegfas.lib.uicompose.typography.font.AndroidFont
import cl.tiocomegfas.lib.uicompose.typography.font.AndroidFontFactory

@Composable
fun MediumText(
    modifier: Modifier = Modifier,
    text: String,
    measurement: Measurement,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = measurement.toSp(),
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Medium,
        color = color,
        fontFamily = UiKitInstance.theme.createFont().getFontFamily()
    )
}