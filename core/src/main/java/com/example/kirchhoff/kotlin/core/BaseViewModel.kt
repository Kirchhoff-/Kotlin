package com.example.kirchhoff.kotlin.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {
  protected val mutableScreenData: MutableLiveData<T> = MutableLiveData()
  val screenData: LiveData<T> = mutableScreenData
}
