package com.example.kirchhoff.kotlin.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * @author Kirchhoff-
 */

val View.ctx: Context
    get() = context


var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)