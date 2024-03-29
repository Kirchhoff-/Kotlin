package com.example.kirchhoff.kotlin.singlenetworkrequest

import androidx.lifecycle.viewModelScope
import com.example.kirchhoff.kotlin.core.BaseViewModel
import com.example.kirchhoff.kotlin.core.ScreenData
import kotlinx.coroutines.launch
import java.io.IOException

class SingleNetworkRequestViewModel(
    private val repository: SingleNetworkRequestRepository = SingleNetworkRequestRepository()
) : BaseViewModel<SingleNetworkRequestScreenData>() {

    fun requestData() {
        mutableScreenData.value = ScreenData.Loading
        viewModelScope.launch {
            try {
                val infoFromServer = repository.requestInfo()
                mutableScreenData.value = ScreenData.Success(SingleNetworkRequestScreenData(infoFromServer))
            } catch (e: IOException) {
                mutableScreenData.value = ScreenData.Error("Network request error: ${e.message}")
            }
        }
    }
}
