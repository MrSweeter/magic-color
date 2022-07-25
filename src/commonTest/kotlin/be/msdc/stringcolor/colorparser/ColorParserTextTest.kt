package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.RGBColor
import be.msdc.stringcolor.colors.TextColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserTextTest {

    //#region Text
    @Test
    fun testYellow() {
        val color = "yellow"
        val expected = RGBColor(255, 255, 0)
        val result = ColorParser.parse(color)
        assertIs<RGBColor>(result)
        assertEquals(expected, result)
    }

    @Test
    fun testSalmon() {
        val color = "salmon"
        val expected = RGBColor(250, 128, 114)
        val result = ColorParser.parse(color)
        assertIs<RGBColor>(result)
        assertEquals(expected, result)
        assertEquals(TextColor.Salmon, result.toTextual())
    }
    //#endregion
}