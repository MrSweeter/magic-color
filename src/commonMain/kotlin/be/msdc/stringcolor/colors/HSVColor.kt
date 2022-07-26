package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.coerceInDegree
import be.msdc.stringcolor.utils.coerceInPct
import be.msdc.stringcolor.utils.toPctInt
import kotlin.math.abs
import kotlin.math.roundToInt

class HSVColor(hue: Int, saturation: Int, value: Int, alpha: Float = 1f) : HueColor(hue, saturation, alpha) {

    private var _value: Int = 0
    var value: Int
        get() = _value
        set(v) {
            _value = v.coerceInPct()
        }

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "${PREFIX_HSVA}($formattedHue, $formattedSaturation, $formattedBrightness, $formattedAlpha)"
        return "${PREFIX_HSV}($formattedHue, $formattedSaturation, $formattedBrightness)"
    }

    val formattedBrightness: String
        get() = "$value%"

    init {
        this.value = value
    }

    override val chroma: Float
        get() {
            val v = value / 100f
            val s = saturation / 100f
            return v * s
        }
    override val hueChroma: Float
        get() = chroma * (1 - abs((hue / 60) % 2 - 1))
    override val move: Float
        get() {
            val v = value / 100f
            return v - chroma
        }

    override fun toHSV(): HSVColor {
        return this
    }

    companion object {
        const val PREFIX_HSV = "hsv"
        const val PREFIX_HSB = "hsb"
        const val PREFIX_HSVA = "hsva"
        const val PREFIX_HSBA = "hsba"

        fun fromRGB(rgbColor: RGBColor): HSVColor {
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

            val brightness = cMax
            val saturation = if (cMax == 0f) 0f else delta / cMax
            return HSVColor(hue, saturation.toPctInt(), brightness.toPctInt(), a)
        }
    }
}
