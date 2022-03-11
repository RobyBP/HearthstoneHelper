package com.robybp.hearthstonehelper.di

import com.robybp.hearthstonehelper.ui.cards.CardsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CardsViewModel()
    }
}
