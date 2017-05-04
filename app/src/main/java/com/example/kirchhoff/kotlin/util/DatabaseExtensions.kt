package com.example.kirchhoff.kotlin.util

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * @author Kirchhoff-
 */
fun <T : Any> SelectQueryBuilder.parseList(
        parser: (Map<String, Any>) -> T): List<T> =
        parseList(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any>): T = parser(columns)
        })


fun <T : Any> SelectQueryBuilder.parseOpt(
        parser: (Map<String, Any>) -> T): T? =
        parseOpt(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any>): T = parser(columns)
        })


fun SQLiteDatabase.clear(tableName: String) {
    execSQL("delete from $tableName")
}

fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> = map({ Pair(it.key, it.value!!) }).toTypedArray()