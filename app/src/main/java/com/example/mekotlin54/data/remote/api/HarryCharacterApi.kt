package com.example.mekotlin54.data.remote.api

import com.example.mekotlin54.data.model.HarryPotterRespons
import retrofit2.Call
import retrofit2.http.GET

private const val CHARACTER ="database.json"
interface  HarryCharacterApi{

    @GET(CHARACTER)
    fun getCharacter(): Call<HarryPotterRespons>
}