package com.robybp.hearthstonehelper.ui.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.robybp.hearthstonehelper.R
import com.robybp.hearthstonehelper.ui.cards.CardsScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen() {

    Scaffold(
        bottomBar = { BottomNavigationBar() },
        content = { CardsScreen(viewModel = getViewModel()) })
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        R.drawable.ic_cards_in_hand,
        R.drawable.ic_chest,
    )
    BottomNavigation {
        items.forEach {
            BottomNavigationItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = "Navigation item icon"
                    )
                })
        }
    }
}
