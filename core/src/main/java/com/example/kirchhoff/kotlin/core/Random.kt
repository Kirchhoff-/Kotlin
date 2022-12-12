package com.example.kirchhoff.kotlin.core

import java.util.UUID
import kotlin.random.Random

@Suppress("unused")
fun Random.nextString(length: Int = 10): String = UUID.randomUUID().toString().substring(length)
