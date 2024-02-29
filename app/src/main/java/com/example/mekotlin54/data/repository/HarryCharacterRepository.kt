package com.example.mekotlin54.data.repository

import android.telecom.Call
import com.example.mekotlin54.data.model.CharactersItems
import com.example.mekotlin54.data.model.HarryPotterRespons
import com.example.mekotlin54.data.remote.RetrofitClient
import retrofit2.Callback
import retrofit2.Response

class HarryCharacterRepository {
    private val apiServise = RetrofitClient.HarryCharacterApi

    fun getCharacter(
        onResponse: (character: List<CharactersItems>) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        apiServise.getCharacter().enqueue(object : Callback<HarryPotterRespons> {

            override fun onResponse(
                call: retrofit2.Call<HarryPotterRespons>,
                response: Response<HarryPotterRespons>
            ) {
                if (response.isSuccessful && response.body() != null)
                    onResponse(response.body()?.characters!!)
            }

            override fun onFailure(call: retrofit2.Call<HarryPotterRespons>, t: Throwable) {
                onFailure(t)

            }
        })
    }
}