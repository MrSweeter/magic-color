package be.msdc.stringcolor.colors

import kotlin.test.Test
import kotlin.test.assertEquals

class CMYKColorTest {

    //#region CMYK to RGB
    @Test
    fun testToRgbBlack() {
        val black = CMYKColor(0, 0, 0, 100)
        val rgb = black.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbWhite() {
        val white = CMYKColor(0, 0, 0, 0)
        val rgb = white.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbRed() {
        val red = CMYKColor(0, 100, 100, 0)
        val rgb = red.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbGreen() {
        val green = CMYKColor(100, 0, 100, 0)
        val rgb = green.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbBlue() {
        val blue = CMYKColor(100, 100, 0, 0)
        val rgb = blue.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbYellow() {
        val yellow = CMYKColor(0, 0, 100, 0)
        val rgb = yellow.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(0, rgb.blue)
    }

    @Test
    fun testToRgbCyan() {
        val cyan = CMYKColor(100, 0, 0, 0)
        val rgb = cyan.toRGB()
        assertEquals(0, rgb.red)
        assertEquals(255, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbMagenta() {
        val magenta = CMYKColor(0, 100, 0, 0)
        val rgb = magenta.toRGB()
        assertEquals(255, rgb.red)
        assertEquals(0, rgb.green)
        assertEquals(255, rgb.blue)
    }

    @Test
    fun testToRgbSilver() {
        val silver = RGBColor(191, 191, 191)
        val hex = silver.toHexadecimal()
        assertEquals(191, hex.red)
        assertEquals(191, hex.green)
        assertEquals(191, hex.blue)
    }

    @Test
    fun testToRgbGray() {
        val gray = RGBColor(128, 128, 128)
        val hex = gray.toHexadecimal()
        assertEquals(128, hex.red)
        assertEquals(128, hex.green)
        assertEquals(128, hex.blue)
    }

    @Test
    fun testToRgbMaroon() {
        val maroon = RGBColor(128, 0, 0)
        val hex = maroon.toHexadecimal()
        assertEquals(128, hex.red)
        assertEquals(0, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToRgbOlive() {
        val olive = RGBColor(128, 128, 0)
        val hex = olive.toHexadecimal()
        assertEquals(128, hex.red)
        assertEquals(128, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToRgbDarkGreen() {
        val darkGreen = RGBColor(0, 128, 0)
        val hex = darkGreen.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(128, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToRgbPurple() {
        val purple = RGBColor(128, 0, 128)
        val hex = purple.toHexadecimal()
        assertEquals(128, hex.red)
        assertEquals(0, hex.green)
        assertEquals(128, hex.blue)
    }

    @Test
    fun testToRgbTeal() {
        val teal = RGBColor(0, 128, 128)
        val hex = teal.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(128, hex.green)
        assertEquals(128, hex.blue)
    }

    @Test
    fun testToRgbNavy() {
        val navy = RGBColor(0, 0, 128)
        val hex = navy.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(0, hex.green)
        assertEquals(128, hex.blue)
    }
    //#endregion

}