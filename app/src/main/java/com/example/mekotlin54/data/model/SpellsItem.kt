package com.example.mekotlin54.data.model

import com.google.gson.annotations.SerializedName

data class SpellsItem(
    @SerializedName("spell")
    val spell: String = "",
    @SerializedName("use")
    val use: String = ""
)