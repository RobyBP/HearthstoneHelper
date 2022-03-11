package com.robybp.hearthstonehelper.ui.cards

import android.util.Log
import com.robybp.hearthstonehelper.core.viewmodel.BaseViewModel
import com.robybp.hearthstonehelper.core.viewstate.Async
import com.robybp.hearthstonehelper.repo.CardsRepository
import kotlinx.coroutines.flow.*

class CardsViewModel(private val cardsRepository: CardsRepository) : BaseViewModel() {

    private val _viewState = MutableStateFlow(CardViewState.EMPTY)
    val viewState = _viewState.asStateFlow()

    init {
        loadCardsByClass("Warrior")
    }

    private fun loadCardsByClass(className: String) {
        runInBackground {
            cardsRepository.getCardsByClass(className)
                .onStart {
                    _viewState.update { cardViewState ->
                        cardViewState.copy(cardListResult = Async.Loading)
                    }
                }
                .catch { throwable ->
                    _viewState.update { cardViewState ->
                        cardViewState.copy(cardListResult = Async.Fail(throwable))
                    }
                }
                .collectLatest { cards ->
                    _viewState.update { cardViewState ->
                        cardViewState.copy(cardListResult = Async.Success(cards.filter { it.imageUrl != null }.distinct()))
                    }
                }
        }
    }
}
