package com.example.kirchhoff.kotlin.sequentialnetworkrequests

import androidx.lifecycle.viewModelScope
import com.example.kirchhoff.kotlin.core.BaseViewModel
import com.example.kirchhoff.kotlin.core.ScreenData
import kotlinx.coroutines.launch
import java.io.IOException

class SequentialNetworkRequestViewModel(
    private val repository: SequentialNetworkRequestRepository = SequentialNetworkRequestRepository()
) : BaseViewModel<SequentialNetworkRequestScreenData>() {

    fun requestData() {
        mutableScreenData.value = ScreenData.Loading
        viewModelScope.launch {
            try {
                val infoFromServer = repository.requestInfo()
                val additionalInfoFromServer =
                    repository.requestAdditionalInfo(infoFromServer.substring(0, KEY_LENGTH))

                mutableScreenData.value = ScreenData.Success(
                    SequentialNetworkRequestScreenData(
                        infoFromServer,
                        additionalInfoFromServer
                    )
                )
            } catch (e: IOException) {
                mutableScreenData.value = ScreenData.Error("Network request error: ${e.message}")
            }
        }
    }

    private companion object {
        const val KEY_LENGTH = 3
    }
}
