package com.example.kirchhoff.kotlin.delegation

import kotlin.reflect.KProperty

/**
 * @author Kirchhoff-
 */

class NameDelegate<T>(private var value: String) {

    operator fun getValue(context: T, property: KProperty<*>): String =
            value.trim().toLowerCase().capitalize()

    operator fun setValue(context: T, property: KProperty<*>, newValue: String) {
        this.value = newValue
    }

}