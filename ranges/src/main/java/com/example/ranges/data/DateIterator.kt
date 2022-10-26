package com.example.ranges.data

import android.annotation.SuppressLint
import java.time.LocalDate

@Suppress("IteratorNotThrowingNoSuchElementException")
@SuppressLint("NewApi")
class DateIterator(
    startDate: LocalDate,
    private val endDateInclusive: LocalDate,
    private val stepDays: Long
) : Iterator<LocalDate> {

    private var currentDate = startDate

    override fun hasNext() = currentDate.plusDays(stepDays) <= endDateInclusive

    override fun next(): LocalDate {
        val next = currentDate
        currentDate = currentDate.plusDays(stepDays)
        return next
    }
}
