package com.example.kirchhoff.kotlin.extensions

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * @author Kirchhoff-
 */

fun View.isVisible(): Boolean = visibility == View.VISIBLE

fun View.setVisibile(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun TextView.setFormatText(string: String, formatArgs: Any) {
    text = string.format(formatArgs)
}

fun TextView.setFormatText(@StringRes stringId: Int, formatArgs: Any) =
        setFormatText(resources.getString(stringId), formatArgs)

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

inline fun View.snack(@StringRes messageId: Int, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) =
        snack(context.getString(messageId), length, f)

fun Snackbar.action(@StringRes actionNameId: Int, color: Int? = null, listener: (View) -> Unit) =
        action(view.context.getString(actionNameId), color, listener)

fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}

typealias SwipeListener = (RecyclerView.ViewHolder, Int) -> Unit

inline fun RecyclerView.setSwipeListener(swipeDirs: Int, crossinline listener: SwipeListener) {
    ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, swipeDirs) {
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) = false

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) = listener(viewHolder, direction)
    }).attachToRecyclerView(this)
}