package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.XYZColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserXYZTest {

    private val redColorResult = XYZColor(0.4125f, 0.2127f, 0.01933f)
    private val darkRedAlphaColorResult = XYZColor(0.2022f, 0.1043f, 0.009478f, 0.5f)

    //#region XYZ
    @Test
    fun testXYZ() {
        val color = "xyz(0.4125, 0.2127, 0.01933)"
        val result = ColorParser.parse(color)
        assertIs<XYZColor>(result)
        assertEquals(redColorResult, result)
    }
    //#endregion

    //#region XYZA
    @Test
    fun testXYZWithAlpha() {
        val color = "xyza(0.2022, 0.1043, 0.00948, 0.5)"
        val result = ColorParser.parse(color)
        assertIs<XYZColor>(result)
        assertEquals(darkRedAlphaColorResult, result)
    }
    //#endregion

}