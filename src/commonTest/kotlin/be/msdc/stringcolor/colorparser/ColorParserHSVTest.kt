package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.HSVColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserHSVTest {

    private val redColorResult = HSVColor(0, 100, 100)
    private val redAlphaColorResult = HSVColor(0, 100, 100, 0.5f)

    //#region HSV
    @Test
    fun testHSV() {
        val color = "hsv(0, 100, 100)"
        val result = ColorParser.parse(color)
        assertIs<HSVColor>(result)
        assertEquals(redColorResult, result)
    }
    //#endregion

    //#region HSVA
    @Test
    fun testHSVWithAlpha() {
        val color = "hsva(0%, 100%, 100%, 0.5)"
        val result = ColorParser.parse(color)
        assertIs<HSVColor>(result)
        assertEquals(redAlphaColorResult, result)
    }
    //#endregion

}