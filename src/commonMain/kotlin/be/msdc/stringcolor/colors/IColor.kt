package be.msdc.stringcolor.colors

abstract class IColor {

    abstract fun toRGB(): RGBColor

    open fun toTextual(): TextColor? {
        return toRGB().toTextual()
    }

    open fun toHexadecimal(): HexadecimalColor {
        return toRGB().toHexadecimal()
    }

    open fun toHSL(): HSLColor {
        return toRGB().toHSL()
    }

    open fun toHSV(): HSVColor {
        return toRGB().toHSV()
    }

    open fun toCMYK(): CMYKColor {
        return toRGB().toCMYK()
    }

    open fun toXYZ(): XYZColor {
        return toRGB().toXYZ()
    }

    open fun toLAB(): LABColor {
        return toRGB().toLAB()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IColor) return false

        return toRGB() == other.toRGB()
    }

    override fun hashCode(): Int {
        return toRGB().hashCode()
    }
}

fun IColor?.isSameColor(other: IColor?): Boolean {
    return this?.toRGB() == other?.toRGB()
}