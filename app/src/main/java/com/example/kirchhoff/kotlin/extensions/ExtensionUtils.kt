package com.example.kirchhoff.kotlin.extensions

import java.text.DateFormat
import java.util.*

/**
 * @author Kirchhoff-
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}