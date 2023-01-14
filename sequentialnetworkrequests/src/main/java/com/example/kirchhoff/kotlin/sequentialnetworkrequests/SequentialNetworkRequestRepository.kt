package com.example.kirchhoff.kotlin.sequentialnetworkrequests

import com.example.kirchhoff.kotlin.core.nextDelayTime
import com.example.kirchhoff.kotlin.core.nextString
import kotlinx.coroutines.delay
import java.io.IOException
import kotlin.random.Random

class SequentialNetworkRequestRepository {

    suspend fun requestInfo(): String {
        delay(Random.nextDelayTime())
        return if (Random.nextBoolean()) {
            Random.nextString()
        } else {
            throw IOException(Random.nextString())
        }
    }

    suspend fun requestAdditionalInfo(key: String): String {
        delay(DELAY_TIME)
        return key + " " + Random.nextDelayTime()
    }

    private companion object {
        const val DELAY_TIME = 500L
    }
}
