package com.example.kirchhoff.kotlin.extensions

import android.view.View

fun View.setVisibile(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}
