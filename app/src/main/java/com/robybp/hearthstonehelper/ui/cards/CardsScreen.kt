package com.robybp.hearthstonehelper.ui.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robybp.hearthstonehelper.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private val mockList = Array(100) { "Test" }
private val mockDrawerContent = listOf("First", "second", "third")

@Composable
fun CardsScreen(viewModel: CardsViewModel) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize()) {
        CardScreenTopAppBar(scope = scope, drawerState = drawerState) {
            Icon(painter = painterResource(id = R.drawable.ic_filter), contentDescription = "")
        }
        ModalDrawer(
            drawerContent = { MyColumn() },
            drawerState = drawerState,
            content = {
                MockList(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
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
fun MockList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        content = { items(mockList) { item -> ListItem(text = item) } })
}

@Composable
fun ListItem(text: String) {
    Text(
        text = text,
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )
}

@Composable
fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {

        mockDrawerContent.forEach { textResId ->
            Text(
                text = textResId,
                fontSize = 22.sp
            )
        }
    }
}
