package com.example.kirchhoff.kotlin.ranges

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import com.example.kirchhoff.kotlin.R
import com.example.kirchhoff.kotlin.ranges.data.rangeTo
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class RangeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range)

        val startDate = LocalDate.of(2020, 1, 1)
        val endDate = LocalDate.of(2020, 12, 31)
        for (date in startDate..endDate step 7) {
            Log.d("RangeActivity", "${date.dayOfWeek} $date ")
        }

        val startDate2 = LocalDate.of(2020, 1, 1)
        val endDate2 = LocalDate.of(2020, 12, 31)
        for (date in startDate2..endDate2 step 2) {
            Log.d("RangeActivity", "${date.dayOfWeek} $date ")
        }

        val startDate3 = LocalDate.of(2020, 1, 1)
        val endDate3 = LocalDate.of(2020, 12, 31)
        if (LocalDate.now() in startDate3..endDate3) Log.d("RangeActivity", "Welcome in 2020!")
    }
}