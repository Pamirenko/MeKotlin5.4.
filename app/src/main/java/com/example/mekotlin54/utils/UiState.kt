package com.example.mekotlin54.utils

data class UiState<T>(
    val isLoading : Boolean = true,
    val errorMessage:String? = null,
    val success: T? = null
)