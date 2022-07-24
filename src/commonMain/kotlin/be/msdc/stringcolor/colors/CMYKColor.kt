package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.keepDecimalAndCoerceIn
import kotlin.math.roundToInt

open class CMYKColor: ColorAlpha {

    constructor(
        cyan: Float,
        magenta: Float,
        yellow: Float,
        key: Float,
        alpha: Float = 1f
    ): super(alpha)  {
        this.cyan = cyan
        this.magenta = magenta
        this.yellow = yellow
        this.key = key
    }

    constructor(cyan: Int, magenta: Int, yellow: Int, key: Int, alpha: Int = 100): this(
        cyan / 100f,
        magenta / 100f,
        yellow / 100f,
        key / 100f,
        alpha / 100f
    )

    private var _cyan: Float = 0f
    var cyan: Float
        get() = _cyan
        set(value) {
            _cyan = value.keepDecimalAndCoerceIn(2, 0f, 1f)
        }
    val cyanPct: Int
        get() = (cyan * 100).roundToInt()

    private var _magenta: Float = 0f
    var magenta: Float
        get() = _magenta
        set(value) {
            _magenta = value.keepDecimalAndCoerceIn(2, 0f, 1f)
        }
    val magentaPct: Int
        get() = (magenta * 100).roundToInt()

    private var _yellow: Float = 0f
    var yellow: Float
        get() = _yellow
        set(value) {
            _yellow = value.keepDecimalAndCoerceIn(2, 0f, 1f)
        }
    val yellowPct: Int
        get() = (yellow * 100).roundToInt()

    private var _key: Float = 0f
    var key: Float
        get() = _key
        set(value) {
            _key = value.keepDecimalAndCoerceIn(2, 0f, 1f)
        }
    val keyPct: Int
        get() = (key * 100).roundToInt()

    val formattedCyan: String
        get() = "${cyanPct}%"
    val formattedMagenta: String
        get() = "${magentaPct}%"
    val formattedYellow: String
        get() = "${yellowPct}%"
    val formattedKey: String
        get() = "${keyPct}%"

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "$PREFIX_CMYKA($formattedCyan, $formattedMagenta, $formattedYellow, $formattedKey, $formattedAlpha)"
        return "$PREFIX_CMYK($formattedCyan, $formattedMagenta, $formattedYellow, $formattedKey)"
    }

    override fun toRGB(): RGBColor {
        val red = 255 * (1 - cyan) * (1 - key)
        val green = 255 * (1 - magenta) * (1 - key)
        val blue = 255 * (1 - yellow) * (1 - key)
        return RGBColor(red.roundToInt(), green.roundToInt(), blue.roundToInt(), alpha)
    }

    override fun toCMYK(): CMYKColor {
        return this
    }

    companion object    {
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
                CMYKColor(c, m, y, k, a)
            } else {
                CMYKColor(0f, 0f, 0f, 1f, a)
            }
        }
    }
}
