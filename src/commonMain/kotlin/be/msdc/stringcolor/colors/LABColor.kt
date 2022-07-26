package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.Illuminant
import kotlin.math.pow

// The Lab model is a color model with 3 components used to describe a color space that is more perceptually uniform than XYZ.
// https://www.google.com/search?q=Lab+color&rlz=1C5CHFA_enBE935BE935&sxsrf=ALiCzsYxUxKTWKh9aLQp-hveIGF2DhquQQ%3A1658688823706&ei=N5XdYvvNKsj5lwSz4IvYBA&ved=0ahUKEwi7xYSxmZL5AhXI_IUKHTPwAksQ4dUDCA4&uact=5&oq=Lab+color&gs_lcp=Cgdnd3Mtd2l6EAMyBAgAEEMyBggAEB4QBzIGCAAQHhAHMgYIABAeEAcyBggAEB4QBzIGCAAQHhAHMgYIABAeEAcyBggAEB4QBzIGCAAQHhAHMgYIABAeEAc6BwgAEEcQsAM6BwgAELADEENKBAhBGABKBAhGGABQzwFYzwFg3gNoAnABeACAAVCIAVCSAQExmAEAoAECoAEByAEJwAEB&sclient=gws-wiz
// http://www.brucelindbloom.com/index.html?Eqn_Lab_to_XYZ.html

class LABColor(l: Float, a: Float, b: Float, alpha: Float = 1f): ColorAlpha(alpha) {

    private var _l: Float = 0f
    var l: Float
        get() = _l
        set(value) {
            _l = value.coerceIn(0f, 100f)
        }

    private var _a: Float = 0f
    var a: Float
        get() = _a
        set(value) {
            _a = value.coerceIn(-128f, 128f)
        }

    private var _b: Float = 0f
    var b: Float
        get() = _b
        set(value) {
            _b = value.coerceIn(-128f, 128f)
        }

    val formattedL
        get() = l.toString()
    val formattedA
        get() = a.toString()
    val formattedB
        get() = b.toString()

    init {
        this.l = l
        this.a = a
        this.b = b
    }

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "$PREFIX_LABA($formattedL, $formattedA, $formattedB, $formattedAlpha)"
        return "$PREFIX_LAB($formattedL, $formattedA, $formattedB)"
    }

    override fun toRGB(): RGBColor {
        return toXYZ().toRGB()
    }

    override fun toXYZ(): XYZColor {
        // 0.008856 Actual CIE standard
        // 216 / 24389 Intent of the CIE standard
        val epsilon = 216 / 24389
        // 903.3 Actual CIE standard
        // 24389 / 27 Intent of the CIE standard
        val kappa = 24389 / 27

        val fy = (l + 16f) / 116f
        val fx = a / 500f + fy
        val fz = fy - b / 200f

        val x0 = if (fx.pow(3) > epsilon) fx.pow(3) else (116 * fx - 16) / kappa
        val y0 = if (l > kappa * epsilon) fy.pow(3) else l / kappa
        val z0 = if (fz.pow(3) > epsilon) fz.pow(3) else (116 * fz - 16) / kappa

        return XYZColor(
            x0 * Illuminant.D65_10.x,
            y0 * Illuminant.D65_10.y,
            z0 * Illuminant.D65_10.z,
            alpha
        )
    }

    companion object {
        const val PREFIX_LAB = "lab"
        const val PREFIX_LABA = "laba"

        fun fromRGB(rgbColor: RGBColor): LABColor {
            return XYZColor.fromRGB(rgbColor).toLAB()
        }
    }
}