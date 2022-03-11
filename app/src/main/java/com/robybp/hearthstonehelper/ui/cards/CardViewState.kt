package com.robybp.hearthstonehelper.ui.cards

import com.robybp.hearthstonehelper.core.viewstate.Async
import com.robybp.hearthstonehelper.model.CardResponse

data class CardViewState(
    val cardListResult: Async<List<CardResponse>> = Async.Uninitialized
) {
    companion object {
        val EMPTY = CardViewState()
    }
}
