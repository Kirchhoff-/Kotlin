package com.example.kirchhoff.kotlin.kotlinbook.domain.commands

/**
 * @author Kirchhoff-
 */
interface Command<T> {

    fun execute(): T
}