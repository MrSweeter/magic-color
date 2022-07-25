package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.RGBColor
import be.msdc.stringcolor.colors.RGBColor.Companion.PREFIX_RGB
import be.msdc.stringcolor.colors.RGBColor.Companion.PREFIX_RGBA

class RGBColorFormatter : ColorArrayFormatter<RGBColor>() {

    override val regexes: Set<PrefixValueRegex> = setOf(
        PrefixValueRegex(PREFIX_RGB, "\\(${bit8},${bit8},${bit8}\\)"),
        PrefixValueRegex(PREFIX_RGBA, "\\(${bit8},${bit8},${bit8},${pctFlt}\\)"),
    )

    override fun serialize(color: RGBColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(prefix: String, value: String): RGBColor? {
        val sanitized = getValues(value, prefix == PREFIX_RGB)

        if (sanitized.size != 4) return null

        val red = sanitized[0].toInt()
        val green = sanitized[1].toInt()
        val blue = sanitized[2].toInt()
        val alpha = sanitized[3].toFloat()

        return RGBColor(red, green, blue, alpha)
    }
}