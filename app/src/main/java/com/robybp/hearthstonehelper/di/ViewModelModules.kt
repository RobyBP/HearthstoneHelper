package com.robybp.hearthstonehelper.di

import com.robybp.hearthstonehelper.ui.cards.CardsViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel {
        CardsViewModel()
    }
}
