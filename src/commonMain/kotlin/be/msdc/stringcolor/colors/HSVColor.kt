package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.coerceInDegree
import be.msdc.stringcolor.utils.keepDecimalAndCoerceIn
import kotlin.math.abs
import kotlin.math.roundToInt

open class HSVColor: HueColor  {

    constructor(hue: Int, saturation: Int, brightness: Int, alpha: Int = 100) : this(hue, saturation / 100f, brightness / 100f, alpha / 100f)
    constructor(hue: Int, saturation: Float, value: Float) : this(hue, saturation, value, 1f)
    constructor(hue: Int, saturation: Float, value: Float, alpha: Float) : super(hue, saturation, alpha)    {
        this.value = value
    }

    private var _value: Float = 0.0f
    var value: Float
        get() = _value
        set(v) {
            _value = v.keepDecimalAndCoerceIn(2, 0f, 1f)
        }
    val valuePct: Int
        get() = (value * 100).roundToInt()

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "${PREFIX_HSVA}($formattedHue, $formattedSaturation, $formattedBrightness, $formattedAlpha)"
        return "${PREFIX_HSV}($formattedHue, $formattedSaturation, $formattedBrightness)"
    }

    val formattedBrightness: String
        get() = "${valuePct}%"

    override val chroma: Float
        get() = value * saturation
    override val hueChroma: Float
        get() = chroma * (1 - abs((hue / 60) % 2 - 1))
    override val move: Float
        get() = value - chroma

    override fun toHSV(): HSVColor {
        return this
    }

    companion object    {
        const val PREFIX_HSV = "hsv"
        const val PREFIX_HSB = "hsb"
        const val PREFIX_HSVA = "hsva"
        const val PREFIX_HSBA = "hsba"

        fun fromRGB(rgbColor: RGBColor): HSVColor   {
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

            val brightness = cMax.keepDecimalAndCoerceIn(2, 0f , 1f)
            val saturation = if (cMax == 0f) 0f else (delta / cMax).keepDecimalAndCoerceIn(2, 0f, 1f)
            return HSVColor(hue, saturation, brightness, a)
        }
    }
}
