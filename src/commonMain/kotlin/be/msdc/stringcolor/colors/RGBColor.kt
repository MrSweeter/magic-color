package be.msdc.stringcolor.colors

open class RGBColor : ColorAlpha {

    constructor(red: Int, green: Int, blue: Int, alpha: Float = 1f) : super(alpha) {
        this.red = red
        this.green = green
        this.blue = blue
    }

    private var _red: Int = 0
    var red: Int
        get() = _red
        set(value) {
            _red = value.coerceIn(0, 255)
        }

    private var _green: Int = 0
    var green: Int
        get() = _green
        set(value) {
            _green = value.coerceIn(0, 255)
        }

    private var _blue: Int = 0
    var blue: Int
        get() = _blue
        set(value) {
            _blue = value.coerceIn(0, 255)
        }

    open val formattedRed: String
        get() = red.toString()
    open val formattedGreen: String
        get() = green.toString()
    open val formattedBlue: String
        get() = blue.toString()

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "${PREFIX_RGBA}($formattedRed, $formattedGreen, $formattedBlue, $formattedAlpha)"
        return "${PREFIX_RGB}($formattedRed, $formattedGreen, $formattedBlue)"
    }

    override fun toRGB(): RGBColor {
        return this
    }

    override fun toTextual(): TextColor? {
        return TextColor.values().firstOrNull { it.rgbColor == this }
    }

    override fun toHexadecimal(): HexadecimalColor {
        return HexadecimalColor.fromRGB(this)
    }

    override fun toHSL(): HSLColor {
        return HSLColor.fromRGB(this)
    }

    override fun toHSV(): HSVColor {
        return HSVColor.fromRGB(this)
    }

    override fun toCMYK(): CMYKColor {
        return CMYKColor.fromRGB(this)
    }

    override fun toXYZ(): XYZColor {
        return XYZColor.fromRGB(this)
    }

    override fun toLAB(): LABColor {
        return LABColor.fromRGB(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RGBColor) return false

        if (red != other.red) return false
        if (green != other.green) return false
        if (blue != other.blue) return false
        if (alpha != other.alpha) return false

        return true
    }

    override fun hashCode(): Int {
        var result = red
        result = 31 * result + green
        result = 31 * result + blue
        result = 31 * result + alpha.hashCode()
        return result
    }

    companion object {
        const val PREFIX_RGB = "rgb"
        const val PREFIX_RGBA = "rgba"
    }
}