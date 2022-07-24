package be.msdc.stringcolor.colors.rgb

import be.msdc.stringcolor.colors.RGBColor
import kotlin.test.Test
import kotlin.test.assertEquals

class RgbToCmyk {

    //#region RGB to CMYK
    @Test
    fun testToCmykBlack() {
        val black = RGBColor(0, 0, 0)
        val cmyk = black.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(1f, cmyk.key)
    }

    @Test
    fun testToCmykWhite() {
        val white = RGBColor(255, 255, 255)
        val cmyk = white.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0f, cmyk.key)
    }

    @Test
    fun testToCmykRed() {
        val cyan = RGBColor(255, 0, 0)
        val cmyk = cyan.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(1f, cmyk.magenta)
        assertEquals(1f, cmyk.yellow)
        assertEquals(0f, cmyk.key)
    }

    @Test
    fun testToCmykGreen() {
        val magenta = RGBColor(0, 255, 0)
        val cmyk = magenta.toCMYK()
        assertEquals(1f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(1f, cmyk.yellow)
        assertEquals(0f, cmyk.key)
    }

    @Test
    fun testToCmykBlue() {
        val blue = RGBColor(0, 0, 255)
        val cmyk = blue.toCMYK()
        assertEquals(1f, cmyk.cyan)
        assertEquals(1f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0f, cmyk.key)
    }

    @Test
    fun testToCmykYellow() {
        val yellow = RGBColor(255, 255, 0)
        val cmyk = yellow.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(1f, cmyk.yellow)
        assertEquals(0f, cmyk.key)
    }

    @Test
    fun testToCmykCyan() {
        val cyan = RGBColor(0, 255, 255)
        val cmyk = cyan.toCMYK()
        assertEquals(1f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0f, cmyk.key)
    }

    @Test
    fun testToCmykMagenta() {
        val magenta = RGBColor(255, 0, 255)
        val cmyk = magenta.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(1f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0f, cmyk.key)
    }

    @Test
    fun testToCmykSilver() {
        val silver = RGBColor(191, 191, 191)
        val cmyk = silver.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0.25f, cmyk.key)
    }

    @Test
    fun testToCmykGray() {
        val gray = RGBColor(128, 128, 128)
        val cmyk = gray.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0.5f, cmyk.key)
    }

    @Test
    fun testToCmykMaroon() {
        val maroon = RGBColor(128, 0, 0)
        val cmyk = maroon.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(1f, cmyk.magenta)
        assertEquals(1f, cmyk.yellow)
        assertEquals(0.5f, cmyk.key)
    }

    @Test
    fun testToCmykOlive() {
        val olive = RGBColor(128, 128, 0)
        val cmyk = olive.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(1f, cmyk.yellow)
        assertEquals(0.5f, cmyk.key)
    }

    @Test
    fun testToCmykDarkGreen() {
        val darkGreen = RGBColor(0, 128, 0)
        val cmyk = darkGreen.toCMYK()
        assertEquals(1f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(1f, cmyk.yellow)
        assertEquals(0.5f, cmyk.key)
    }

    @Test
    fun testToCmykPurple() {
        val purple = RGBColor(128, 0, 128)
        val cmyk = purple.toCMYK()
        assertEquals(0f, cmyk.cyan)
        assertEquals(1f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0.5f, cmyk.key)
    }

    @Test
    fun testToCmykTeal() {
        val teal = RGBColor(0, 128, 128)
        val cmyk = teal.toCMYK()
        assertEquals(1f, cmyk.cyan)
        assertEquals(0f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0.5f, cmyk.key)
    }

    @Test
    fun testToCmykNavy() {
        val navy = RGBColor(0, 0, 128)
        val cmyk = navy.toCMYK()
        assertEquals(1f, cmyk.cyan)
        assertEquals(1f, cmyk.magenta)
        assertEquals(0f, cmyk.yellow)
        assertEquals(0.5f, cmyk.key)
    }
    //#endregion

}