package cl.tiocomegfas.lib.uicompose.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.tiocomegfas.lib.uicompose.measurement.Measurement
import cl.tiocomegfas.lib.uicompose.spacer.VerticalSpacerExtraSmall
import cl.tiocomegfas.lib.uicompose.spacer.VerticalSpacerLarge
import cl.tiocomegfas.lib.uicompose.spacer.VerticalSpacerMedium
import cl.tiocomegfas.lib.uicompose.spacer.VerticalSpacerSmall
import cl.tiocomegfas.lib.uicompose.text.BoldText
import cl.tiocomegfas.lib.uicompose.text.MediumText
import cl.tiocomegfas.lib.uicompose.text.RegularText

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
            .padding(Measurement.SIZE_40.toDp()),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 5.dp
        ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.background,

        )
    ) {
        BoldText(
            modifier = Modifier.wrapContentWidth(),
            text = title,
            measurement = Measurement.SIZE_32,
            color = MaterialTheme.colorScheme.onBackground
        )
        VerticalSpacerSmall()
        RegularText(
            modifier = Modifier.wrapContentWidth(),
            text = content,
            measurement = Measurement.SIZE_24,
            color = MaterialTheme.colorScheme.onBackground
        )
        VerticalSpacerExtraSmall()
        MediumText(
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.Start)
                .clickable { onClickMoreContent.invoke() },
            text = moreContent,
            measurement = Measurement.SIZE_24,
            color = MaterialTheme.colorScheme.primary
        )
    }
}