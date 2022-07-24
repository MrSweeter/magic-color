package be.msdc.stringcolor.colors

import kotlin.test.Test
import kotlin.test.assertEquals

class HSVColorTest {

    //#region HSV to RGB
    @Test
    fun testToRgbBlack() {
        val black = HSVColor(0, 0, 0)
        val rgb = black.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbWhite() {
        val white = HSVColor(0, 0, 100)
        val rgb = white.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbRed() {
        val red = HSVColor(0, 100, 100)
        val rgb = red.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbGreen() {
        val green = HSVColor(120, 100, 100)
        val rgb = green.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbBlue() {
        val blue = HSVColor(240, 100, 100)
        val rgb = blue.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbYellow() {
        val yellow = HSVColor(60, 100, 100)
        val rgb = yellow.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbCyan() {
        val cyan = HSVColor(180, 100, 100)
        val rgb = cyan.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbMagenta() {
        val magenta = HSVColor(300, 100, 100)
        val rgb = magenta.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbSilver() {
        val silver = HSVColor(0, 0, 75)
        val rgb = silver.toRGB()
        assertEquals(191, rgb.red)
        assertEquals(191, rgb.green)
        assertEquals(191, rgb.blue)
    }

    @Test
    fun testToRgbGray() {
        val gray = HSVColor(0, 0, 50)
        val rgb = gray.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbMaroon() {
        val maroon = HSVColor(0, 100, 50)
        val rgb = maroon.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbOlive() {
        val olive = HSVColor(60, 100, 50)
        val rgb = olive.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbDarkGreen() {
        val darkGreen = HSVColor(120, 100, 50)
        val rgb = darkGreen.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbPurple() {
        val purple = HSVColor(300, 100, 50)
        val rgb = purple.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbTeal() {
        val teal = HSVColor(180, 100, 50)
        val rgb = teal.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbNavy() {
        val navy = HSVColor(240, 100, 50)
        val rgb = navy.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(128, rgb.blue)
    }
    //#endregion

}
