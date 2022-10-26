package com.example.ranges

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ranges.data.rangeTo
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class RangeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range)

        val startDate = LocalDate.of(YEAR, START_MONTH, START_DAY)
        val endDate = LocalDate.of(YEAR, END_MONTH, END_DAY)
        for (date in startDate..endDate step WEEK) {
            Log.d("RangeActivity", "${date.dayOfWeek} $date ")
        }

        val startDate2 = LocalDate.of(YEAR, START_MONTH, START_DAY)
        val endDate2 = LocalDate.of(YEAR, END_MONTH, END_DAY)
        for (date in startDate2..endDate2 step TWO_DAYS) {
            Log.d("RangeActivity", "${date.dayOfWeek} $date ")
        }

        val startDate3 = LocalDate.of(YEAR, START_MONTH, START_DAY)
        val endDate3 = LocalDate.of(YEAR, END_MONTH, END_DAY)
        if (LocalDate.now() in startDate3..endDate3) Log.d("RangeActivity", "Welcome in 2020!")
    }

    private companion object {
        const val YEAR = 2022
        const val START_MONTH = 1
        const val END_MONTH = 12
        const val START_DAY = 1
        const val END_DAY = 31
        const val TWO_DAYS = 2L
        const val WEEK = 7L
    }
}
