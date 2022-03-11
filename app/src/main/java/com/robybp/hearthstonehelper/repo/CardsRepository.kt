package com.robybp.hearthstonehelper.repo

import com.robybp.hearthstonehelper.model.CardResponse
import kotlinx.coroutines.flow.Flow

interface CardsRepository {

    fun getCardsByClass(name: String): Flow<List<CardResponse>>

    fun getSingleCard(name: String): Flow<List<CardResponse>>

    fun getCardsByType(typeName: String): Flow<List<CardResponse>>

    fun getAllCards(): Flow<List<CardResponse>>
}
