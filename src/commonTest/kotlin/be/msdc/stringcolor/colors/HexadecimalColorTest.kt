package be.msdc.stringcolor.colors

import kotlin.test.Test
import kotlin.test.assertEquals

class HexadecimalColorTest {

    //#region HEX to RGB
    @Test
    fun testToRgbBlack() {
        val black = HexadecimalColor(0, 0, 0)
        val rgb = black.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbWhite() {
        val white = HexadecimalColor(255, 255, 255)
        val rgb = white.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbRed() {
        val red = HexadecimalColor(255, 0, 0)
        val rgb = red.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbGreen() {
        val green = HexadecimalColor(0, 255, 0)
        val rgb = green.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbBlue() {
        val blue = HexadecimalColor(0, 0, 255)
        val rgb = blue.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbYellow() {
        val yellow = HexadecimalColor(255, 255, 0)
        val rgb = yellow.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbCyan() {
        val cyan = HexadecimalColor(0, 255, 255)
        val rgb = cyan.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbMagenta() {
        val magenta = HexadecimalColor(255, 0, 255)
        val rgb = magenta.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbSilver() {
        val silver = HexadecimalColor(191, 191, 191)
        val rgb = silver.toRGB()
        assertEquals(191, rgb.red)
        assertEquals(191, rgb.green)
        assertEquals(191, rgb.blue)
    }

    @Test
    fun testToRgbGray() {
        val gray = HexadecimalColor(128, 128, 128)
        val rgb = gray.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbMaroon() {
        val maroon = HexadecimalColor(128, 0, 0)
        val rgb = maroon.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbOlive() {
        val olive = HexadecimalColor(128, 128, 0)
        val rgb = olive.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbDarkGreen() {
        val darkGreen = HexadecimalColor(0, 128, 0)
        val rgb = darkGreen.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbPurple() {
        val purple = HexadecimalColor(128, 0, 128)
        val rgb = purple.toRGB()
        assertEquals(128, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbTeal() {
        val teal = HexadecimalColor(0, 128, 128)
        val rgb = teal.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(128, rgb.green)
        assertEquals(128, rgb.blue)
    }

    @Test
    fun testToRgbNavy() {
        val navy = HexadecimalColor(0, 0, 128)
        val rgb = navy.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(128, rgb.blue)
    }
    //#endregion
}