package com.example.kirchhoff.kotlin.ranges.data

import java.time.LocalDate

operator fun LocalDate.rangeTo(other: LocalDate): DateProgression = DateProgression(this, other)
