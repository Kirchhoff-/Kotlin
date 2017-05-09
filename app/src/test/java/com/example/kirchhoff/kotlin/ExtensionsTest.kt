package com.example.kirchhoff.kotlin

import com.example.kirchhoff.kotlin.extensions.toDateString
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.text.DateFormat

/**
 * @author Kirchhoff-
 */
class ExtensionsTest {

    @Test
    fun testLongToDateString() {
        assertEquals("Oct 19, 2015", 1445275635000L.toDateString())
    }

    @Test fun testDateStringFullFormat() {
        assertEquals("Monday, October 19, 2015",
                1445275635000L.toDateString(DateFormat.FULL))
    }


}