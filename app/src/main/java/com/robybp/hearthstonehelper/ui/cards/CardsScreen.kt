package com.robybp.hearthstonehelper.ui.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.robybp.hearthstonehelper.R
import com.robybp.hearthstonehelper.core.viewstate.Async
import com.robybp.hearthstonehelper.core.viewstate.Async.*
import com.robybp.hearthstonehelper.model.CardResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CardsScreen(viewModel: CardsViewModel) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val viewState = viewModel.viewState.collectAsState()

    Column(Modifier.fillMaxSize()) {
        CardScreenTopAppBar(scope = scope, drawerState = drawerState) {
            Icon(painter = painterResource(id = R.drawable.ic_filter), contentDescription = "")
        }
        ModalDrawer(
            drawerContent = { },
            drawerState = drawerState,
            content = {
                CardResultList(
                    content = viewState.value.cardListResult,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                )
            }
        )
    }
}

@Composable
fun CardScreenTopAppBar(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    scope: CoroutineScope,
    navigationIcon: @Composable (() -> Unit)
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(
                onClick = { scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() } },
                content = navigationIcon
            )
        }
    )
}

@Composable
fun CardResultList(content: Async<List<CardResponse>>, modifier: Modifier = Modifier) {
    when (content) {
        is Fail -> ErrorMessage(modifier)
        is Loading -> LoadingIcon(modifier)
        is Success -> GridView(columnCount = 2, cards = content.value)
        Uninitialized -> {}
    }
}

@Composable
fun ErrorMessage(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription = "Error image",
            )
            Text(
                text = "Something went wrong while loading your cards.",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun LoadingIcon(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = "Loading your cards")
    }
}
