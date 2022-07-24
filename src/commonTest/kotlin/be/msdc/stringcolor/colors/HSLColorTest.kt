package be.msdc.stringcolor.colors

import kotlin.test.Test
import kotlin.test.assertEquals

class HSLColorTest {

    //#region HSL to RGB
    @Test
    fun testToRgbBlack() {
        val black = HSLColor(0, 0, 0)
        val rgb = black.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbWhite() {
        val white = HSLColor(0, 0, 100)
        val rgb = white.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbRed() {
        val red = HSLColor(0, 100, 50)
        val rgb = red.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbGreen() {
        val green = HSLColor(120, 100, 50)
        val rgb = green.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbBlue() {
        val blue = HSLColor(240, 100, 50)
        val rgb = blue.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbYellow() {
        val yellow = HSLColor(60, 100, 50)
        val rgb = yellow.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbCyan() {
        val cyan = HSLColor(180, 100, 50)
        val rgb = cyan.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbMagenta() {
        val magenta = HSLColor(300, 100, 50)
        val rgb = magenta.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbSilver() {
        val silver = HSLColor(0, 0, 75)
        val rgb = silver.toRGB()
        assertEquals(191, rgb.red)
        assertEquals(191, rgb.green)
        assertEquals(191, rgb.blue)
    }

    @Test
    fun testToRgbGray() {
        val gray = HSLColor(0, 0, 50)
        val rgb = gray.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbMaroon() {
        val maroon = HSLColor(0, 100, 25)
        val rgb = maroon.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbOlive() {
        val olive = HSLColor(60, 100, 25)
        val rgb = olive.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbDarkGreen() {
        val darkGreen = HSLColor(120, 100, 25)
        val rgb = darkGreen.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbPurple() {
        val purple = HSLColor(300, 100, 25)
        val rgb = purple.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbTeal() {
        val teal = HSLColor(180, 100, 25)
        val rgb = teal.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbNavy() {
        val navy = HSLColor(240, 100, 25)
        val rgb = navy.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(128, rgb.blue)
    }
    //#endregion
}
