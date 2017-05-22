package com.importre.crayon

import org.junit.Test
import kotlin.test.assertEquals

class CrayonTest {

    @Test
    fun testRed() {
        val text = "red"
        val expected = red + text + reset
        val actual = text.red()
        assertEquals(expected, actual)
    }

    @Test
    fun testBgRed() {
        val text = "red"
        val expected = bgRed + text + reset
        val actual = text.bgRed()
        assertEquals(expected, actual)
    }

    @Test
    fun testRawRed() {
        val text = "red"
        val expected = "\\u001b[41m$text\\u001b[0m"
        val actual = text.bgRed().raw()
        assertEquals(expected, actual)
    }
}
