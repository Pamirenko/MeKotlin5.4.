@OptIn
    (UnstableApi::class) package com.example.mekotlin54.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.mekotlin54.R
import com.example.mekotlin54.data.repository.HarryCharacterRepository
import com.example.mekotlin54.utils.UiState


class CharacterViewModel<CharactersItems> : ViewModel() {
    private val characterRepository = HarryCharacterRepository()
    private val _characterLiveData = MutableLiveData<UiState<List<CharactersItems>>>()
    val characterLiveData: LiveData<UiState<List<CharactersItems>>> = _characterLiveData

    init {
        Log.e("narte", "model" )
        characterRepository.getCharacter(
            onResponse = {data->
                Log.e("TAG", "harry,$data" )
                _characterLiveData.value = UiState(isLoading = false, success = data)
            },
            onFailure = {t->

                Log.e("narte", "model,$t" )
                _characterLiveData.value = UiState(isLoading = false,errorMessage = t.message?:"error")

            }
        )
    }
}