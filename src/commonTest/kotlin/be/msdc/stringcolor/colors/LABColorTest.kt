package be.msdc.stringcolor.colors

import kotlin.test.Test
import kotlin.test.assertEquals

class LABColorTest {

    @Test
    fun testToRgbRed() {
        val red = LABColor(53.25f, 80.40f, 67.25f)
        val rgb = red.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbDarkRed() {
        val red = LABColor(24.84f, 47.41f, 37.16f)
        val rgb = red.toRGB()
        assertEquals(125, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

}