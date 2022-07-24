package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserHSVTest   {

    private val redColorResult = HSVColor(0, 1.0f, 1.0f)
    private val redAlphaColorResult = HSVColor(0, 1.0f, 1.0f, 0.5f)

    //#region HSV
    @Test
    fun testHSVFloat() {
        val color = "hsv(0, 1, 1.0)"
        val result = ColorParser.parse(color)
        assertIs<HSVColor>(result)
        assertEquals(redColorResult, result)
    }

    @Test
    fun testHSVInt() {
        val color = "hsv(0, 100%, 100%)"
        val result = ColorParser.parse(color)
        assertIs<HSVColor>(result)
        assertEquals(redColorResult, result)
    }
    //#endregion

    //#region HSVA
    @Test
    fun testHSVWithAlphaFloat() {
        val color = "hsva(0, 1.0, 1.0, 0.5)"
        val result = ColorParser.parse(color)
        assertIs<HSVColor>(result)
        assertEquals(redAlphaColorResult, result)
    }

    @Test
    fun testHSVWithAlphaInt() {
        val color = "hsva(0, 100%, 100%, 50)"
        val result = ColorParser.parse(color)
        assertIs<HSVColor>(result)
        assertEquals(redAlphaColorResult, result)
    }
    //#endregion

}