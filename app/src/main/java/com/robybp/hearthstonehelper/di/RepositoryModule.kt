package com.robybp.hearthstonehelper.di

import com.robybp.hearthstonehelper.repo.CardsRepository
import com.robybp.hearthstonehelper.repo.CardsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<CardsRepository> { CardsRepositoryImpl(get()) }
}
