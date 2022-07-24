package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.padStart

class HexadecimalColor: RGBColor  {

    constructor(red: Int, green: Int, blue: Int, alpha: Float = 1f): super(red, green, blue, alpha)
    constructor(red: Int, green: Int, blue: Int): this(red, green, blue, 1f)
    constructor(red: Int, green: Int, blue: Int, alpha: Int): this(red, green, blue, alpha / 255f)

    override val formattedRed: String
        get() = red.padStart(16, 2)
    override val formattedGreen: String
        get() = green.padStart(16, 2)
    override val formattedBlue: String
        get() = blue.padStart(16, 2)
    override val formattedAlpha: String
        get() = alphaPct.padStart(16, 2)

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "$PREFIX_HEX$formattedAlpha$formattedRed$formattedGreen$formattedBlue"
        return "$PREFIX_HEX$formattedRed$formattedGreen$formattedBlue"
    }

    override fun toHexadecimal(): HexadecimalColor {
        return this
    }

    companion object    {
        const val PREFIX_HEX = "#"
        const val PREFIX_HEX_X = "0x"

        fun fromRGB(rgbColor: RGBColor): HexadecimalColor {
            return HexadecimalColor(rgbColor.red, rgbColor.green, rgbColor.blue, rgbColor.alpha)
        }
    }
}
