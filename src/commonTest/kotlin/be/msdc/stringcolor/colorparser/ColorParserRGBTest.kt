package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserRGBTest   {

    private val redColorResult = RGBColor(255, 0, 0)
    private val redAlphaColorResult = RGBColor(255, 0, 0, 0.5f)

    //#region RGB
    @Test
    fun testRGB() {
        val color = "rgb(255, 0, 0)"
        val result = ColorParser.parse(color)
        assertIs<RGBColor>(result)
        assertEquals(redColorResult, result)
    }
    //#endregion

    //#region RGBA
    @Test
    fun testRGBWithAlphaFloat() {
        val color = "rgba(255, 0, 0, 0.5)"
        val result = ColorParser.parse(color)
        assertIs<RGBColor>(result)
        assertEquals(redAlphaColorResult, result)
        assertEquals(color, result.toString())
    }

    @Test
    fun testRGBWithAlphaInt() {
        val color = "rgba(255, 0, 0, 50)"
        val result = ColorParser.parse(color)
        assertIs<RGBColor>(result)
        assertEquals(redAlphaColorResult, result)
    }
    //#endregion
}