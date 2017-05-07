package com.example.kirchhoff.kotlin.domain.commands

/**
 * @author Kirchhoff-
 */
interface Command<T> {

    fun execute(): T
}