package com.example.kirchhoff.kotlin.delegation

/**
 * @author Kirchhoff-
 */
class User(name: String, surname: String) {
    val userName: String by NameDelegate(name)
    val userSurname: String by NameDelegate(surname)
}