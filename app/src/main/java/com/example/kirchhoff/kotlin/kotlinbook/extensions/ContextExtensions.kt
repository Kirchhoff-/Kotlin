package com.example.kirchhoff.kotlin.kotlinbook.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * @author Kirchhoff-
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)