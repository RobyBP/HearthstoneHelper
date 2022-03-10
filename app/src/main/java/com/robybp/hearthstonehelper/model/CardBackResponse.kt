package com.robybp.hearthstonehelper.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardBackResponse(
    @SerialName("cardBackId")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("source")
    val source: Int,
    @SerialName("howToGet")
    val howToGet: String,
    @SerialName("enabled")
    val isEnabled: Boolean,
    @SerialName("img")
    val imageUrl: String?,
    @SerialName("imgAnimated")
    val animatedImageUrl: String?,
    @SerialName("sortCategory")
    val sortCategory: Int,
    @SerialName("sortOrder")
    val sortOrder: Int,
    @SerialName("locale")
    val locale: String
)
