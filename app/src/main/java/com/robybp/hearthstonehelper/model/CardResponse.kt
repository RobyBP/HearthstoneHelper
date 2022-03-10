package com.robybp.hearthstonehelper.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardResponse(
    @SerialName("cardId")
    val id: String,
    @SerialName("dbFId")
    val databaseId: Long,
    @SerialName("name")
    val name: String,
    @SerialName("cardSet")
    val cardSet: String,
    @SerialName("type")
    val type: String?,
    @SerialName("faction")
    val faction: String,
    @SerialName("rarity")
    val rarity: String,
    @SerialName("cost")
    val cost: Int,
    @SerialName("attack")
    val attack: Int,
    @SerialName("health")
    val health: Int,
    @SerialName("durability")
    val durability: Int?,
    @SerialName("armor")
    val armor: Int,
    @SerialName("inPlayText")
    val inPlayText: String,
    @SerialName("text")
    val description: String,
    @SerialName("flavour")
    val flavour: String,
    @SerialName("artist")
    val artist: String,
    @SerialName("collectable")
    val isCollectable: Boolean,
    @SerialName("elite")
    val isElite: Boolean,
    @SerialName("race")
    val race: String,
    @SerialName("playerClass")
    val playerClass: String,
    @SerialName("multiClassGroup")
    val isMultiClass: Boolean,
    @SerialName("classes")
    val multipleClasses: List<String>?,
    @SerialName("img")
    val imageUrl: String?,
    @SerialName("imgGold")
    val goldenImageUrl: String?,
    @SerialName("locale")
    val locale: String,
    @SerialName("mechanics")
    val mechanics: List<Mechanics>?,
    @SerialName("howToGet")
    val howToGet: String?,
    @SerialName("howToGetGold")
    val howToGetGold: String?,
)

@Serializable
data class Mechanics(
    @SerialName("name")
    val name: String
)
