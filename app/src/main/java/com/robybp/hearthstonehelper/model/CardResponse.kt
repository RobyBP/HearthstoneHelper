package com.robybp.hearthstonehelper.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class CardResponse(
    @SerialName("cardId")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("cardSet")
    val cardSet: String,
    @SerialName("type")
    val type: String,
    @SerialName("faction")
    val faction: String? = null,
    @SerialName("rarity")
    val rarity: String? = null,
    @SerialName("cost")
    val cost: Int? = null,
    @SerialName("attack")
    val attack: Int? = null,
    @SerialName("health")
    val health: Int? = null,
    @SerialName("durability")
    val durability: Int? = null,
    @SerialName("armor")
    val armor: Int? = null,
    @SerialName("inPlayText")
    val inPlayText: String? = "",
    @SerialName("text")
    val description: String = "",
    @SerialName("flavour")
    val flavour: String = "",
    @SerialName("artist")
    val artist: String = "Unknown",
    @SerialName("collectable")
    val isCollectable: Boolean? = null,
    @SerialName("elite")
    val isElite: Boolean? = null,
    @SerialName("race")
    val race: String? = "Undefined",
    @SerialName("playerClass")
    val playerClass: String,
    @SerialName("multiClassGroup")
    val isMultiClass: Boolean? = null,
    @SerialName("classes")
    val multipleClasses: List<String> = listOf(),
    @SerialName("img")
    val imageUrl: String? = null,
    @SerialName("imgGold")
    val goldenImageUrl: String? = null,
    @SerialName("locale")
    val locale: String,
    @SerialName("mechanics")
    val mechanics: List<Mechanics> = listOf(),
    @SerialName("howToGet")
    val howToGet: String = "Unknown",
    @SerialName("howToGetGold")
    val howToGetGold: String = "Unknown",
)

@Serializable
data class Mechanics(
    @SerialName("name")
    val name: String
)
