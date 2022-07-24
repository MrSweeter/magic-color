package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.HSLColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserHSLTest {

    private val redColorResult = HSLColor(0, 100, 50)
    private val redAlphaColorResult = HSLColor(0, 100, 50, 0.5f)

    //#region HSL
    @Test
    fun testHSL() {
        val color = "hsl(0, 100, 50)"
        val result = ColorParser.parse(color)
        assertIs<HSLColor>(result)
        assertEquals(redColorResult, result)
    }
    //#endregion

    //#region HSLA
    @Test
    fun testHSLWithAlpha() {
        val color = "hsla(0%, 100%, 50%, .5)"
        val result = ColorParser.parse(color)
        assertIs<HSLColor>(result)
        assertEquals(redAlphaColorResult, result)
    }
    //#endregion
}