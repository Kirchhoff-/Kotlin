package com.example.kirchhoff.kotlin

/**
 * @author Kirchhoff-
 */
public interface Command<T> {

    fun execute(): T
}