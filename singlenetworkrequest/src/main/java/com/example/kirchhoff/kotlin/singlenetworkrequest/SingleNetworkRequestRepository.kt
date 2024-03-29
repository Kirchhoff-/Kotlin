package com.example.kirchhoff.kotlin.singlenetworkrequest

import com.example.kirchhoff.kotlin.core.nextString
import kotlinx.coroutines.delay
import java.io.IOException
import kotlin.random.Random

class SingleNetworkRequestRepository {
    suspend fun requestInfo(): String {
        delay(DELAY_TIME)
        return if (Random.nextBoolean()) {
            Random.nextString()
        } else {
            throw IOException(Random.nextString())
        }
    }

    private companion object {
        const val DELAY_TIME = 5000L
    }
}
