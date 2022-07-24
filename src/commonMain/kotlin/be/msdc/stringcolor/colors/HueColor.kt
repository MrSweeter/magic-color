package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.coerceInDegree
import be.msdc.stringcolor.utils.coerceInPct
import kotlin.math.roundToInt

abstract class HueColor(hue: Int, saturation: Int, alpha: Float) : ColorAlpha(alpha) {

    private var _hue: Int = 0
    var hue: Int
        get() = _hue
        set(value) {
            _hue = value.coerceInDegree()
        }

    private var _saturation: Int = 0
    var saturation: Int
        get() = _saturation
        set(value) {
            _saturation = value.coerceInPct()
        }

    val formattedHue: String
        get() = "$hue°"
    val formattedSaturation: String
        get() = "$saturation%"

    init {
        this.hue = hue
        this.saturation = saturation
    }

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