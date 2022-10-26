package com.example.ranges.data

import java.time.LocalDate

class DateProgression(
    override val endInclusive: LocalDate,
    override val start: LocalDate,
    val stepDays: Long = 1
) : Iterable<LocalDate>, ClosedRange<LocalDate> {

    override fun iterator(): Iterator<LocalDate> =
        DateIterator(start, endInclusive, stepDays)

    infix fun step(days: Long) = DateProgression(start, endInclusive, days)
}
