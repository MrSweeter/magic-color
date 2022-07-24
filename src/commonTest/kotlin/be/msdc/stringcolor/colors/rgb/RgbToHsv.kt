package be.msdc.stringcolor.colors.rgb

import be.msdc.stringcolor.colors.RGBColor
import kotlin.test.Test
import kotlin.test.assertEquals

class RgbToHsv {

    //#region RGB to HSV
    @Test
    fun testToHsvBlack() {
        val black = RGBColor(0, 0, 0)
        val hsv = black.toHSV()
        assertEquals(0, hsv.hue)
        assertEquals(0, hsv.saturation)
        assertEquals(0, hsv.value)
    }

    @Test
    fun testToHsvWhite() {
        val white = RGBColor(255, 255, 255)
        val hsv = white.toHSV()
        assertEquals(0, hsv.hue)
        assertEquals(0, hsv.saturation)
        assertEquals(100, hsv.value)
    }

    @Test
    fun testToHsvRed() {
        val red = RGBColor(255, 0, 0)
        val hsv = red.toHSV()
        assertEquals(0, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(100, hsv.value)
    }

    @Test
    fun testToHsvGreen() {
        val green = RGBColor(0, 255, 0)
        val hsv = green.toHSV()
        assertEquals(120, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(100, hsv.value)
    }

    @Test
    fun testToHsvBlue() {
        val blue = RGBColor(0, 0, 255)
        val hsv = blue.toHSV()
        assertEquals(240, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(100, hsv.value)
    }

    @Test
    fun testToHsvYellow() {
        val yellow = RGBColor(255, 255, 0)
        val hsv = yellow.toHSV()
        assertEquals(60, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(100, hsv.value)
    }

    @Test
    fun testToHsvCyan() {
        val cyan = RGBColor(0, 255, 255)
        val hsv = cyan.toHSV()
        assertEquals(180, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(100, hsv.value)
    }

    @Test
    fun testToHsvMagenta() {
        val magenta = RGBColor(255, 0, 255)
        val hsv = magenta.toHSV()
        assertEquals(300, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(100, hsv.value)
    }

    @Test
    fun testToHsvSilver() {
        val silver = RGBColor(191, 191, 191)
        val hsv = silver.toHSV()
        assertEquals(0, hsv.hue)
        assertEquals(0, hsv.saturation)
        assertEquals(75, hsv.value)
    }

    @Test
    fun testToHsvGray() {
        val gray = RGBColor(128, 128, 128)
        val hsv = gray.toHSV()
        assertEquals(0, hsv.hue)
        assertEquals(0, hsv.saturation)
        assertEquals(50, hsv.value)
    }

    @Test
    fun testToHsvMaroon() {
        val maroon = RGBColor(128, 0, 0)
        val hsv = maroon.toHSV()
        assertEquals(0, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(50, hsv.value)
    }

    @Test
    fun testToHsvOlive() {
        val olive = RGBColor(128, 128, 0)
        val hsv = olive.toHSV()
        assertEquals(60, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(50, hsv.value)
    }

    @Test
    fun testToHsvDarkGreen() {
        val darkGreen = RGBColor(0, 128, 0)
        val hsv = darkGreen.toHSV()
        assertEquals(120, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(50, hsv.value)
    }

    @Test
    fun testToHsvPurple() {
        val purple = RGBColor(128, 0, 128)
        val hsv = purple.toHSV()
        assertEquals(300, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(50, hsv.value)
    }

    @Test
    fun testToHsvTeal() {
        val teal = RGBColor(0, 128, 128)
        val hsv = teal.toHSV()
        assertEquals(180, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(50, hsv.value)
    }

    @Test
    fun testToHsvNavy() {
        val navy = RGBColor(0, 0, 128)
        val hsv = navy.toHSV()
        assertEquals(240, hsv.hue)
        assertEquals(100, hsv.saturation)
        assertEquals(50, hsv.value)
    }
    //#endregion

}