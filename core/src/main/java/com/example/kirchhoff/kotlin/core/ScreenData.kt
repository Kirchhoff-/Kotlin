package com.example.kirchhoff.kotlin.core

sealed class ScreenData<T> {
    data class Success<T>(val data: T) : ScreenData<T>()
    data class Error(val message: String) : ScreenData<Nothing>()
    object Loading : ScreenData<Nothing>()
}
