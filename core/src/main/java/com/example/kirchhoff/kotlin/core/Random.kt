package com.example.kirchhoff.kotlin.core

import java.util.UUID
import kotlin.random.Random

@Suppress("unused")
fun Random.nextString(length: Int = 10): String = UUID.randomUUID().toString().substring(length)

fun Random.nextDelayTime(maxDelayTime: Long = 5000): Long = Random.nextLong(0, maxDelayTime)
