package be.msdc.stringcolor.colors.rgb

import be.msdc.stringcolor.colors.RGBColor
import kotlin.test.Test
import kotlin.test.assertEquals

class RgbToHex {

    //#region RGB to Hexadecimal
    @Test
    fun testToHexadecimalBlack() {
        val black = RGBColor(0, 0, 0)
        val hex = black.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(0, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToHexadecimalWhite() {
        val white = RGBColor(255, 255, 255)
        val hex = white.toHexadecimal()
        assertEquals(255, hex.red)
        assertEquals(255, hex.green)
        assertEquals(255, hex.blue)
    }

    @Test
    fun testToHexadecimalRed() {
        val red = RGBColor(255, 0, 0)
        val hex = red.toHexadecimal()
        assertEquals(255, hex.red)
        assertEquals(0, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToHexadecimalGreen() {
        val green = RGBColor(0, 255, 0)
        val hex = green.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(255, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToHexadecimalBlue() {
        val blue = RGBColor(0, 0, 255)
        val hex = blue.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(0, hex.green)
        assertEquals(255, hex.blue)
    }

    @Test
    fun testToHexadecimalYellow() {
        val yellow = RGBColor(255, 255, 0)
        val hex = yellow.toHexadecimal()
        assertEquals(255, hex.red)
        assertEquals(255, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToHexadecimalCyan() {
        val cyan = RGBColor(0, 255, 255)
        val hex = cyan.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(255, hex.green)
        assertEquals(255, hex.blue)
    }

    @Test
    fun testToHexadecimalMagenta() {
        val magenta = RGBColor(255, 0, 255)
        val hex = magenta.toHexadecimal()
        assertEquals(255, hex.red)
        assertEquals(0, hex.green)
        assertEquals(255, hex.blue)
    }

    @Test
    fun testToHexadecimalSilver() {
        val silver = RGBColor(191, 191, 191)
        val hex = silver.toHexadecimal()
        assertEquals(191, hex.red)
        assertEquals(191, hex.green)
        assertEquals(191, hex.blue)
    }

    @Test
    fun testToHexadecimalGray() {
        val gray = RGBColor(128, 128, 128)
        val hex = gray.toHexadecimal()
        assertEquals(128, hex.red)
        assertEquals(128, hex.green)
        assertEquals(128, hex.blue)
    }

    @Test
    fun testToHexadecimalMaroon() {
        val maroon = RGBColor(128, 0, 0)
        val hex = maroon.toHexadecimal()
        assertEquals(128, hex.red)
        assertEquals(0, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToHexadecimalOlive() {
        val olive = RGBColor(128, 128, 0)
        val hex = olive.toHexadecimal()
        assertEquals(128, hex.red)
        assertEquals(128, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToHexadecimalDarkGreen() {
        val darkGreen = RGBColor(0, 128, 0)
        val hex = darkGreen.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(128, hex.green)
        assertEquals(0, hex.blue)
    }

    @Test
    fun testToHexadecimalPurple() {
        val purple = RGBColor(128, 0, 128)
        val hex = purple.toHexadecimal()
        assertEquals(128, hex.red)
        assertEquals(0, hex.green)
        assertEquals(128, hex.blue)
    }

    @Test
    fun testToHexadecimalTeal() {
        val teal = RGBColor(0, 128, 128)
        val hex = teal.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(128, hex.green)
        assertEquals(128, hex.blue)
    }

    @Test
    fun testToHexadecimalNavy() {
        val navy = RGBColor(0, 0, 128)
        val hex = navy.toHexadecimal()
        assertEquals(0, hex.red)
        assertEquals(0, hex.green)
        assertEquals(128, hex.blue)
    }
    //#endregion

}