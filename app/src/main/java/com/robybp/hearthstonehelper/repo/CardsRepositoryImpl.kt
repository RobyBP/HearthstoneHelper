package com.robybp.hearthstonehelper.repo

import com.robybp.hearthstonehelper.model.CardResponse
import com.robybp.hearthstonehelper.network.CardsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CardsRepositoryImpl(private val cardsService: CardsService) : CardsRepository {

    override fun getCardsByClass(name: String): Flow<List<CardResponse>> = flow {
        emit(cardsService.getCardsByClass(name))
    }

    override fun getSingleCard(name: String): Flow<List<CardResponse>> {
        TODO("Not yet implemented")
    }

    override fun getCardsByType(typeName: String): Flow<List<CardResponse>> {
        TODO("Not yet implemented")
    }

    override fun getAllCards(): Flow<List<CardResponse>> {
        TODO("Not yet implemented")
    }
}
