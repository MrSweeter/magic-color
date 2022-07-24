package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.coerceInPct
import be.msdc.stringcolor.utils.toPctInt
import kotlin.math.roundToInt

open class CMYKColor(cyan: Int, magenta: Int, yellow: Int, key: Int, alpha: Float = 1f) : ColorAlpha(alpha) {

    private var _cyan: Int = 0
    var cyan: Int
        get() = _cyan
        set(value) {
            _cyan = value.coerceInPct()
        }

    private var _magenta: Int = 0
    var magenta: Int
        get() = _magenta
        set(value) {
            _magenta = value.coerceInPct()
        }

    private var _yellow: Int = 0
    var yellow: Int
        get() = _yellow
        set(value) {
            _yellow = value.coerceInPct()
        }

    private var _key: Int = 0
    var key: Int
        get() = _key
        set(value) {
            _key = value.coerceInPct()
        }

    val formattedCyan: String
        get() = "$cyan%"
    val formattedMagenta: String
        get() = "$magenta%"
    val formattedYellow: String
        get() = "$yellow%"
    val formattedKey: String
        get() = "$key%"

    init {
        this.cyan = cyan
        this.magenta = magenta
        this.yellow = yellow
        this.key = key
    }

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "$PREFIX_CMYKA($formattedCyan, $formattedMagenta, $formattedYellow, $formattedKey, $formattedAlpha)"
        return "$PREFIX_CMYK($formattedCyan, $formattedMagenta, $formattedYellow, $formattedKey)"
    }

    override fun toRGB(): RGBColor {
        val c = cyan.toFloat() / 100
        val m = magenta.toFloat() / 100
        val y = yellow.toFloat() / 100
        val k = key.toFloat() / 100

        val red = 255 * (1 - c) * (1 - k)
        val green = 255 * (1 - m) * (1 - k)
        val blue = 255 * (1 - y) * (1 - k)
        return RGBColor(red.roundToInt(), green.roundToInt(), blue.roundToInt(), alpha)
    }

    override fun toCMYK(): CMYKColor {
        return this
    }

    companion object {
        const val PREFIX_CMYK = "cmyk"
        const val PREFIX_CMYKA = "cmyka"

        fun fromRGB(rgbColor: RGBColor): CMYKColor {
            val r = rgbColor.red / 255f
            val g = rgbColor.green / 255f
            val b = rgbColor.blue / 255f
            val a = rgbColor.alpha

            val k = 1 - maxOf(r, g, b)
            return if (k != 1f) {
                val c = (1 - r - k) / (1 - k)
                val m = (1 - g - k) / (1 - k)
                val y = (1 - b - k) / (1 - k)
                CMYKColor(c.toPctInt(), m.toPctInt(), y.toPctInt(), k.toPctInt(), a)
            } else {
                CMYKColor(0, 0, 0, 100, a)
            }
        }
    }
}
