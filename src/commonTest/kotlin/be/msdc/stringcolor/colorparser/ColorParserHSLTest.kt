package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserHSLTest   {

    private val redColorResult = HSLColor(0, 1.0f, 0.5f)
    private val redAlphaColorResult = HSLColor(0, 1.0f, 0.5f, 0.5f)

    //#region HSL
    @Test
    fun testHSLFloat() {
        val color = "hsl(0, 1, 0.5)"
        val result = ColorParser.parse(color)
        assertIs<HSLColor>(result)
        assertEquals(redColorResult, result)
    }

    @Test
    fun testHSLInt() {
        val color = "hsl(0, 100%, 50%)"
        val result = ColorParser.parse(color)
        assertIs<HSLColor>(result)
        assertEquals(redColorResult, result)
    }
    //#endregion

    //#region HSLA
    @Test
    fun testHSLWithAlphaFloat() {
        val color = "hsla(0, 1.0, 0.5, 0.5)"
        val result = ColorParser.parse(color)
        assertIs<HSLColor>(result)
        assertEquals(redAlphaColorResult, result)
    }

    @Test
    fun testHSLWithAlphaInt() {
        val color = "hsla(0, 100%, 50%, 50)"
        val result = ColorParser.parse(color)
        assertIs<HSLColor>(result)
        assertEquals(redAlphaColorResult, result)
    }
    //#endregion
}