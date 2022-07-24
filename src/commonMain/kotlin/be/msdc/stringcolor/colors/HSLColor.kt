package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.coerceInDegree
import be.msdc.stringcolor.utils.keepDecimalAndCoerceIn
import kotlin.math.abs
import kotlin.math.roundToInt

class HSLColor: HueColor  {

    constructor(hue: Int, saturation: Int, lightness: Int, alpha: Int = 100) : this(hue, saturation / 100f, lightness / 100f, alpha / 100f)
    constructor(hue: Int, saturation: Float, lightness: Float) : this(hue, saturation, lightness, 1f)
    constructor(hue: Int, saturation: Float, lightness: Float, alpha: Float) : super(hue, saturation, alpha)    {
        this.lightness = lightness
    }

    private var _lightness: Float = 0.0f
    var lightness: Float
        get() = _lightness
        set(value) {
            _lightness = value.keepDecimalAndCoerceIn(2, 0f, 1f)
        }
    val lightnessPct: Int
        get() = (lightness * 100).roundToInt()

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "${PREFIX_HSLA}($formattedHue, $formattedSaturation, $formattedLightness, $formattedAlpha)"
        return "${PREFIX_HSL}($formattedHue, $formattedSaturation, $formattedLightness)"
    }

    val formattedLightness: String
        get() = "${lightnessPct}%"

    override val chroma: Float
        get() = (1 - abs(2 * lightness - 1)) * saturation
    override val hueChroma: Float
        get() = chroma * (1 - abs((hue / 60) % 2 - 1))
    override val move: Float
        get() = lightness - chroma / 2

    override fun toHSL(): HSLColor {
        return this
    }

    companion object    {
        const val PREFIX_HSL = "hsl"
        const val PREFIX_HSLA = "hsla"

        fun fromRGB(rgbColor: RGBColor): HSLColor   {
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

            val lightness = ((cMax + cMin) / 2f).keepDecimalAndCoerceIn(2, 0f, 1f)
            val saturation = if (delta == 0f) 0f else (delta / (1 - abs(2 * lightness - 1))).keepDecimalAndCoerceIn(2, 0f, 1f)
            return HSLColor(hue, saturation, lightness, a)
        }
    }
}
