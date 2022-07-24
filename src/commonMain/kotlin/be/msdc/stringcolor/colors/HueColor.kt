package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.coerceInDegree
import be.msdc.stringcolor.utils.keepDecimalAndCoerceIn
import kotlin.math.roundToInt

abstract class HueColor: ColorAlpha {

    constructor(hue: Int, saturation: Float, alpha: Float) : super(alpha) {
        this.hue = hue
        this.saturation = saturation
    }

    override val formattedAlpha: String
        get() = "${alphaPct}%"

    private var _hue: Int = 0
    var hue: Int
        get() = _hue
        set(value) {
            _hue = value.coerceInDegree()
        }

    private var _saturation: Float = 0f
    var saturation: Float
        get() = _saturation
        set(value) {
            _saturation = value.keepDecimalAndCoerceIn(2, 0f, 1f)
        }
    val saturationPct: Int
        get() = (saturation * 100).roundToInt()

    val formattedHue: String
        get() = "${hue}°"
    val formattedSaturation: String
        get() = "${saturationPct}%"

    protected abstract val chroma: Float
    protected abstract val hueChroma: Float
    protected abstract val move: Float
    override fun toRGB(): RGBColor {
        val c = chroma
        val x = hueChroma
        val m = move

        val rgb = when (hue) {
            in 0..60 -> Triple(c, x, 0f)
            in 61..120 -> Triple(x, c, 0f)
            in 121..180 -> Triple(0f, c, x)
            in 181..240 -> Triple(0f, x, c)
            in 241..300 -> Triple(x, 0f, c)
            in 301..360 -> Triple(c, 0f, x)
            else -> Triple(0f, 0f, 0f)
        }

        return RGBColor(
            ((rgb.first + m) * 255).roundToInt(),
            ((rgb.second + m) * 255).roundToInt(),
            ((rgb.third + m) * 255).roundToInt(),
            alpha
        )
    }
}