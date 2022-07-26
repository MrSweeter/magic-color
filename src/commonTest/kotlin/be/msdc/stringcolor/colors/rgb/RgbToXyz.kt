package be.msdc.stringcolor.colors.rgb

import be.msdc.stringcolor.colors.RGBColor
import kotlin.test.Test
import kotlin.test.assertEquals

class RgbToXyz {

    private val tolerance = 0.00005f

    //#region RGB to HSV
    /*@Test
    fun testToXyzBlack() {
        val black = RGBColor(0, 0, 0)
        val xyz = black.toXYZ()
        assertEquals(0, xyz.x)
        assertEquals(0, xyz.y)
        assertEquals(0, xyz.z)
    }

    @Test
    fun testToXyzWhite() {
        val white = RGBColor(255, 255, 255)
        val xyz = white.toXYZ()
        assertEquals(0, xyz.x)
        assertEquals(0, xyz.y)
        assertEquals(100, xyz.z)
    }*/

    @Test
    fun testToXyzRed() {
        val red = RGBColor(255, 0, 0)
        val xyz = red.toXYZ()
        assertEquals(0.4125f, xyz.x, tolerance)
        assertEquals(0.2127f, xyz.y, tolerance)
        assertEquals(0.01933f, xyz.z, tolerance)
    }

    @Test
    fun testToXyzDarkRed() {
        val red = RGBColor(125, 0, 0)
        val xyz = red.toXYZ()
        assertEquals(0.2022f, xyz.x, tolerance)
        assertEquals(0.1043f, xyz.y, tolerance)
        assertEquals(0.009478f, xyz.z, tolerance)
    }

    /*@Test
    fun testToXyzGreen() {
        val green = RGBColor(0, 255, 0)
        val xyz = green.toXYZ()
        assertEquals(120, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(100, xyz.z)
    }

    @Test
    fun testToXyzBlue() {
        val blue = RGBColor(0, 0, 255)
        val xyz = blue.toXYZ()
        assertEquals(240, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(100, xyz.z)
    }

    @Test
    fun testToXyzYellow() {
        val yellow = RGBColor(255, 255, 0)
        val xyz = yellow.toXYZ()
        assertEquals(60, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(100, xyz.z)
    }

    @Test
    fun testToXyzCyan() {
        val cyan = RGBColor(0, 255, 255)
        val xyz = cyan.toXYZ()
        assertEquals(180, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(100, xyz.z)
    }

    @Test
    fun testToXyzMagenta() {
        val magenta = RGBColor(255, 0, 255)
        val xyz = magenta.toXYZ()
        assertEquals(300, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(100, xyz.z)
    }

    @Test
    fun testToXyzSilver() {
        val silver = RGBColor(191, 191, 191)
        val xyz = silver.toXYZ()
        assertEquals(0, xyz.x)
        assertEquals(0, xyz.y)
        assertEquals(75, xyz.z)
    }

    @Test
    fun testToXyzGray() {
        val gray = RGBColor(128, 128, 128)
        val xyz = gray.toXYZ()
        assertEquals(0, xyz.x)
        assertEquals(0, xyz.y)
        assertEquals(50, xyz.z)
    }

    @Test
    fun testToXyzMaroon() {
        val maroon = RGBColor(128, 0, 0)
        val xyz = maroon.toXYZ()
        assertEquals(0, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(50, xyz.z)
    }

    @Test
    fun testToXyzOlive() {
        val olive = RGBColor(128, 128, 0)
        val xyz = olive.toXYZ()
        assertEquals(60, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(50, xyz.z)
    }

    @Test
    fun testToXyzDarkGreen() {
        val darkGreen = RGBColor(0, 128, 0)
        val xyz = darkGreen.toXYZ()
        assertEquals(120, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(50, xyz.z)
    }

    @Test
    fun testToXyzPurple() {
        val purple = RGBColor(128, 0, 128)
        val xyz = purple.toXYZ()
        assertEquals(300, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(50, xyz.z)
    }

    @Test
    fun testToXyzTeal() {
        val teal = RGBColor(0, 128, 128)
        val xyz = teal.toXYZ()
        assertEquals(180, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(50, xyz.z)
    }

    @Test
    fun testToXyzNavy() {
        val navy = RGBColor(0, 0, 128)
        val xyz = navy.toXYZ()
        assertEquals(240, xyz.x)
        assertEquals(100, xyz.y)
        assertEquals(50, xyz.z)
    }*/
    //#endregion

}