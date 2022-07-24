package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserCMYKTest   {

    private val redColorResult = CMYKColor(0f,1f,1f,0f)
    private val redAlphaColorResult = CMYKColor(0f,1f,1f,0f, 0.5f)

    //#region CMYK
    @Test
    fun testCMYKFloat() {
        val color = "cmyk(0, 1, 1.0, 0)"
        val result = ColorParser.parse(color)
        assertIs<CMYKColor>(result)
        assertEquals(redColorResult, result)
    }
    //#endregion

    //#region CMYKA
    @Test
    fun testCMYKInt() {
        val color = "cmyka(0, 100%, 100%, 0, 50%)"
        val result = ColorParser.parse(color)
        assertIs<CMYKColor>(result)
        assertEquals(redAlphaColorResult, result)
    }
    //#endregion
}