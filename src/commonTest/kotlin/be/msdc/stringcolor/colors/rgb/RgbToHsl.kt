package be.msdc.stringcolor.colors.rgb

import be.msdc.stringcolor.colors.RGBColor
import kotlin.test.Test
import kotlin.test.assertEquals

class RgbToHsl {

    //#region RGB to HSL
    @Test
    fun testToHslBlack() {
        val black = RGBColor(0, 0, 0)
        val hsl = black.toHSL()
        assertEquals(0, hsl.hue)
        assertEquals(0f, hsl.saturation)
        assertEquals(0f, hsl.lightness)
    }

    @Test
    fun testToHslWhite() {
        val white = RGBColor(255, 255, 255)
        val hsl = white.toHSL()
        assertEquals(0, hsl.hue)
        assertEquals(0f, hsl.saturation)
        assertEquals(1f, hsl.lightness)
    }

    @Test
    fun testToHslRed() {
        val red = RGBColor(255, 0, 0)
        val hsl = red.toHSL()
        assertEquals(0, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.5f, hsl.lightness)
    }

    @Test
    fun testToHslGreen() {
        val green = RGBColor(0, 255, 0)
        val hsl = green.toHSL()
        assertEquals(120, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.5f, hsl.lightness)
    }

    @Test
    fun testToHslBlue() {
        val blue = RGBColor(0, 0, 255)
        val hsl = blue.toHSL()
        assertEquals(240, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.5f, hsl.lightness)
    }

    @Test
    fun testToHslYellow() {
        val yellow = RGBColor(255, 255, 0)
        val hsl = yellow.toHSL()
        assertEquals(60, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.5f, hsl.lightness)
    }

    @Test
    fun testToHslCyan() {
        val cyan = RGBColor(0, 255, 255)
        val hsl = cyan.toHSL()
        assertEquals(180, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.5f, hsl.lightness)
    }

    @Test
    fun testToHslMagenta() {
        val magenta = RGBColor(255, 0, 255)
        val hsl = magenta.toHSL()
        assertEquals(300, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.5f, hsl.lightness)
    }

    @Test
    fun testToHslSilver() {
        val silver = RGBColor(191, 191, 191)
        val hsl = silver.toHSL()
        assertEquals(0, hsl.hue)
        assertEquals(0f, hsl.saturation)
        assertEquals(0.75f, hsl.lightness)
    }

    @Test
    fun testToHslGray() {
        val gray = RGBColor(128, 128, 128)
        val hsl = gray.toHSL()
        assertEquals(0, hsl.hue)
        assertEquals(0f, hsl.saturation)
        assertEquals(0.5f, hsl.lightness)
    }

    @Test
    fun testToHslMaroon() {
        val maroon = RGBColor(128, 0, 0)
        val hsl = maroon.toHSL()
        assertEquals(0, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.25f, hsl.lightness)
    }

    @Test
    fun testToHslOlive() {
        val olive = RGBColor(128, 128, 0)
        val hsl = olive.toHSL()
        assertEquals(60, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.25f, hsl.lightness)
    }

    @Test
    fun testToHslDarkGreen() {
        val darkGreen = RGBColor(0, 128, 0)
        val hsl = darkGreen.toHSL()
        assertEquals(120, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.25f, hsl.lightness)
    }

    @Test
    fun testToHslPurple() {
        val purple = RGBColor(128, 0, 128)
        val hsl = purple.toHSL()
        assertEquals(300, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.25f, hsl.lightness)
    }

    @Test
    fun testToHslTeal() {
        val teal = RGBColor(0, 128, 128)
        val hsl = teal.toHSL()
        assertEquals(180, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.25f, hsl.lightness)
    }

    @Test
    fun testToHslNavy() {
        val navy = RGBColor(0, 0, 128)
        val hsl = navy.toHSL()
        assertEquals(240, hsl.hue)
        assertEquals(1f, hsl.saturation)
        assertEquals(0.25f, hsl.lightness)
    }
    //#endregion

}