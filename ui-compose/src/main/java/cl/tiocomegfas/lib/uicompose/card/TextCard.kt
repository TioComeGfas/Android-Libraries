package cl.tiocomegfas.lib.uicompose.card

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.tiocomegfas.lib.uicompose.size.Size
import cl.tiocomegfas.lib.uicompose.typography.style.AndroidStyleFactory
import cl.tiocomegfas.lib.uicompose.typography.style.TitleAndroidStyle

@Composable
fun TextCard(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    moreContent: String,
    onClickMoreContent: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(Size.SIZE_40.toDp())
    ) {
        // Title with text
        Text(
            text = title
        )
    }
}