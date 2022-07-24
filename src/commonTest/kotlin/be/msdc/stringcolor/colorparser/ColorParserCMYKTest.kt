package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.CMYKColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserCMYKTest {

    private val redColorResult = CMYKColor(0, 100, 100, 0)
    private val redAlphaColorResult = CMYKColor(0, 100, 100, 0, 0.5f)

    //#region CMYK
    @Test
    fun testCMYK() {
        val color = "cmyk(0, 100, 100, 0)"
        val result = ColorParser.parse(color)
        assertIs<CMYKColor>(result)
        assertEquals(redColorResult, result)
    }
    //#endregion

    //#region CMYKA
    @Test
    fun testCMYKAlpha() {
        val color = "cmyka(0%, 100%, 100%, 0%, .5)"
        val result = ColorParser.parse(color)
        assertIs<CMYKColor>(result)
        assertEquals(redAlphaColorResult, result)
    }
    //#endregion
}