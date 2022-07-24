package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.coerceInDegree
import be.msdc.stringcolor.utils.coerceInPct
import be.msdc.stringcolor.utils.toPctInt
import kotlin.math.abs
import kotlin.math.roundToInt

class HSLColor(hue: Int, saturation: Int, lightness: Int, alpha: Float = 1f) : HueColor(hue, saturation, alpha) {

    private var _lightness: Int = 0
    var lightness: Int
        get() = _lightness
        set(value) {
            _lightness = value.coerceInPct()
        }

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "${PREFIX_HSLA}($formattedHue, $formattedSaturation, $formattedLightness, $formattedAlpha)"
        return "${PREFIX_HSL}($formattedHue, $formattedSaturation, $formattedLightness)"
    }

    val formattedLightness: String
        get() = "$lightness%"

    init {
        this.lightness = lightness
    }

    override val chroma: Float
        get() {
            val l = lightness / 100f
            val s = saturation / 100f
            return (1 - abs(2 * l - 1)) * s
        }
    override val hueChroma: Float
        get() = chroma * (1 - abs((hue / 60) % 2 - 1))
    override val move: Float
        get() {
            val l = lightness / 100f
            return l - chroma / 2
        }

    override fun toHSL(): HSLColor {
        return this
    }

    companion object {
        const val PREFIX_HSL = "hsl"
        const val PREFIX_HSLA = "hsla"

        fun fromRGB(rgbColor: RGBColor): HSLColor {
            val r = rgbColor.red / 255f
            val g = rgbColor.green / 255f
            val b = rgbColor.blue / 255f
            val a = rgbColor.alpha

            val cMax = maxOf(r, g, b)
            val cMin = minOf(r, g, b)
            val delta = cMax - cMin

            val hue = when {
                delta == 0f -> 0
                cMax == r -> 60 * (((g - b) / delta) % 6).roundToInt()
                cMax == g -> 60 * (((b - r) / delta) + 2).roundToInt()
                cMax == b -> 60 * (((r - g) / delta) + 4).roundToInt()
                else -> 0
            }.coerceInDegree()

            val lightness = ((cMax + cMin) / 2f)
            val saturation = if (delta == 0f) 0f else delta / (1 - abs(2 * lightness - 1))
            return HSLColor(hue, saturation.toPctInt(), lightness.toPctInt(), a)
        }
    }
}
