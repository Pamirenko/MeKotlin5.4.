package com.example.mekotlin54.data.model

import com.google.gson.annotations.SerializedName

data class HarryPotterRespons (
    @SerializedName("characters")
    val characters: List<CharactersItems>?,
    @SerializedName("spells")
    val spells: List<SpellsItem>?,
    @SerializedName("info")
    val info: List<InfoItem>?
)
