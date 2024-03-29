package com.example.kirchhoff.kotlin.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {
    protected val mutableScreenData: MutableLiveData<ScreenData<out T>> = MutableLiveData()
    val screenData: LiveData<ScreenData<out T>> = mutableScreenData
}
