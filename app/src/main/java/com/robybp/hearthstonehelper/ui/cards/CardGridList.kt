package com.robybp.hearthstonehelper.ui.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.robybp.hearthstonehelper.model.CardResponse
import kotlin.math.ceil

@Immutable
private data class IconResource(val imageUrl: String, val name: String, val isVisible: Boolean)

@Composable
fun GridView(columnCount: Int, cards: List<CardResponse>) {
    val itemSize = cards.size
    val rowCount = ceil(itemSize.toFloat() / columnCount).toInt()
    val gridItems = mutableListOf<List<IconResource>>()
    var position = 0

    for (i in 0 until rowCount) {
        val rowItem = mutableListOf<IconResource>()
        for (j in 0 until columnCount) {
            if (position.inc() <= itemSize) {
                val card = cards[position++]
                rowItem.add(IconResource(card.imageUrl!!, card.name, true))
            }
        }

        val itemsToFill = columnCount - rowItem.size

        for (j in 0 until itemsToFill) {
            rowItem.add(IconResource("", "", false))
        }
        gridItems.add(rowItem)
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(gridItems) { items ->
            RowItem(items)
        }
    }
}

@Composable
private fun RowItem(rowItems: List<IconResource>) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        for (element in rowItems)
            GridIconAndText(element)
    }
}

@Composable
private fun GridIconAndText(iconResource: IconResource) {
    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = iconResource.imageUrl,
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = iconResource.name,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
            )
        }
    }
}
