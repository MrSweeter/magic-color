package be.msdc.stringcolor.colorparser

import be.msdc.stringcolor.ColorParser
import be.msdc.stringcolor.colors.HexadecimalColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ColorParserHexadecimalTest {

    private val redColorResult = HexadecimalColor(255, 0, 0)
    private val redAlphaColorResult = HexadecimalColor(255, 0, 0, 0.5f)

    //#region HEX
    @Test
    fun testHexadecimalWithLengthOf3() {
        val color = "#f00"
        val result = ColorParser.parse(color)
        assertIs<HexadecimalColor>(result)
        assertEquals(redColorResult, result)
    }

    @Test
    fun testHexadecimalWithLengthOf4() {
        val color = "#ff00"
        val result = ColorParser.parse(color)
        assertIs<HexadecimalColor>(result)
        assertEquals(redColorResult, result)
    }

    @Test
    fun testHexadecimalWithLengthOf6() {
        val color = "#ff0000"
        val result = ColorParser.parse(color)
        assertIs<HexadecimalColor>(result)
        assertEquals(redColorResult, result)
    }

    @Test
    fun testHexadecimalWithLengthOf8() {
        val color = "#80ff0000"
        val result = ColorParser.parse(color)
        assertIs<HexadecimalColor>(result)
        assertEquals(redAlphaColorResult, result)
    }

    @Test
    fun testHexadecimalXWithLengthOf3() {
        val color = "0xf00"
        val result = ColorParser.parse(color)
        assertIs<HexadecimalColor>(result)
        assertEquals(redColorResult, result)
    }

    @Test
    fun testHexadecimalXWithLengthOf4() {
        val color = "0xff00"
        val result = ColorParser.parse(color)
        assertIs<HexadecimalColor>(result)
        assertEquals(redColorResult, result)
    }

    @Test
    fun testHexadecimalXWithLengthOf6() {
        val color = "0xff0000"
        val result = ColorParser.parse(color)
        assertIs<HexadecimalColor>(result)
        assertEquals(redColorResult, result)
    }

    @Test
    fun testHexadecimalXWithLengthOf8() {
        val color = "0x80ff0000"
        val result = ColorParser.parse(color)
        assertIs<HexadecimalColor>(result)
        assertEquals(redAlphaColorResult, result)
    }
    //#endregion
}