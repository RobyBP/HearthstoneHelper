package com.robybp.hearthstonehelper.ui.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.robybp.hearthstonehelper.R

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { TopScaffoldBar() },
        content = {},
        bottomBar = { BottomNavigationBar() }
    )
}

@Composable
fun TopScaffoldBar() {
    TopAppBar(
        title = { Text(text = "Cards screen") },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "filter icon"
            )
        }
    )
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
