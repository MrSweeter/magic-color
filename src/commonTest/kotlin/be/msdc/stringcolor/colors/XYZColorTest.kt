package be.msdc.stringcolor.colors

import kotlin.test.Test
import kotlin.test.assertEquals

class XYZColorTest {

    @Test
    fun testToRgbRed() {
        val red = XYZColor(0.4125f, 0.2127f, 0.01933f)
        val rgb = red.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbDarkRed() {
        val red = XYZColor(0.2022f, 0.1043f, 0.009478f)
        val rgb = red.toRGB()
        assertEquals(125, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

}