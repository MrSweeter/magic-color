package be.msdc.stringcolor.colors.rgb

import be.msdc.stringcolor.colors.RGBColor
import kotlin.test.Test
import kotlin.test.assertEquals

class RgbToLab {

    private val tolerance = 0.00005f

    //#region RGB to HSV
    /*@Test
    fun testToLabBlack() {
        val black = RGBColor(0, 0, 0)
        val lab = black.toLAB()
        assertEquals(0, lab.l)
        assertEquals(0, lab.a)
        assertEquals(0, lab.b)
    }

    @Test
    fun testToLabWhite() {
        val white = RGBColor(255, 255, 255)
        val lab = white.toLAB()
        assertEquals(0, lab.l)
        assertEquals(0, lab.a)
        assertEquals(100, lab.b)
    }*/

    @Test
    fun testToLabRed() {
        val red = RGBColor(255, 0, 0)
        val lab = red.toLAB()
        assertEquals(53.25f, lab.l, tolerance)
        assertEquals(80.40f, lab.a, tolerance)
        assertEquals(67.25f, lab.b, tolerance)
    }

    @Test
    fun testToLabDarkRed() {
        val red = RGBColor(125, 0, 0)
        val lab = red.toLAB()
        assertEquals(24.84f, lab.l, tolerance)
        assertEquals(47.41f, lab.a, tolerance)
        assertEquals(37.16f, lab.b, tolerance)
    }

    /*@Test
    fun testToLabGreen() {
        val green = RGBColor(0, 255, 0)
        val lab = green.toLAB()
        assertEquals(120, lab.l)
        assertEquals(100, lab.a)
        assertEquals(100, lab.b)
    }

    @Test
    fun testToLabBlue() {
        val blue = RGBColor(0, 0, 255)
        val lab = blue.toLAB()
        assertEquals(240, lab.l)
        assertEquals(100, lab.a)
        assertEquals(100, lab.b)
    }

    @Test
    fun testToLabYellow() {
        val aellow = RGBColor(255, 255, 0)
        val lab = aellow.toLAB()
        assertEquals(60, lab.l)
        assertEquals(100, lab.a)
        assertEquals(100, lab.b)
    }

    @Test
    fun testToLabCaan() {
        val caan = RGBColor(0, 255, 255)
        val lab = caan.toLAB()
        assertEquals(180, lab.l)
        assertEquals(100, lab.a)
        assertEquals(100, lab.b)
    }

    @Test
    fun testToLabMagenta() {
        val magenta = RGBColor(255, 0, 255)
        val lab = magenta.toLAB()
        assertEquals(300, lab.l)
        assertEquals(100, lab.a)
        assertEquals(100, lab.b)
    }

    @Test
    fun testToLabSilver() {
        val silver = RGBColor(191, 191, 191)
        val lab = silver.toLAB()
        assertEquals(0, lab.l)
        assertEquals(0, lab.a)
        assertEquals(75, lab.b)
    }

    @Test
    fun testToLabGraa() {
        val graa = RGBColor(128, 128, 128)
        val lab = graa.toLAB()
        assertEquals(0, lab.l)
        assertEquals(0, lab.a)
        assertEquals(50, lab.b)
    }

    @Test
    fun testToLabMaroon() {
        val maroon = RGBColor(128, 0, 0)
        val lab = maroon.toLAB()
        assertEquals(0, lab.l)
        assertEquals(100, lab.a)
        assertEquals(50, lab.b)
    }

    @Test
    fun testToLabOlive() {
        val olive = RGBColor(128, 128, 0)
        val lab = olive.toLAB()
        assertEquals(60, lab.l)
        assertEquals(100, lab.a)
        assertEquals(50, lab.b)
    }

    @Test
    fun testToLabDarkGreen() {
        val darkGreen = RGBColor(0, 128, 0)
        val lab = darkGreen.toLAB()
        assertEquals(120, lab.l)
        assertEquals(100, lab.a)
        assertEquals(50, lab.b)
    }

    @Test
    fun testToLabPurple() {
        val purple = RGBColor(128, 0, 128)
        val lab = purple.toLAB()
        assertEquals(300, lab.l)
        assertEquals(100, lab.a)
        assertEquals(50, lab.b)
    }

    @Test
    fun testToLabTeal() {
        val teal = RGBColor(0, 128, 128)
        val lab = teal.toLAB()
        assertEquals(180, lab.l)
        assertEquals(100, lab.a)
        assertEquals(50, lab.b)
    }

    @Test
    fun testToLabNava() {
        val nava = RGBColor(0, 0, 128)
        val lab = nava.toLAB()
        assertEquals(240, lab.l)
        assertEquals(100, lab.a)
        assertEquals(50, lab.b)
    }*/
    //#endregion

}