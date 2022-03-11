package com.robybp.hearthstonehelper.network

import com.robybp.hearthstonehelper.model.CardResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface CardsService {

    @GET("cards/classes/{class}")
    suspend fun getCardsByClass(@Path("class") className: String): List<CardResponse>
}
