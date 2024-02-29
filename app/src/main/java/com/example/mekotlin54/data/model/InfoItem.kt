package com.example.mekotlin54.data.model

import com.google.gson.annotations.SerializedName

data class InfoItem(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("content")
    val content: String = ""
)