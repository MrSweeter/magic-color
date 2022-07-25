package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.HSLColor
import be.msdc.stringcolor.colors.HSLColor.Companion.PREFIX_HSL
import be.msdc.stringcolor.colors.HSLColor.Companion.PREFIX_HSLA

class HSLColorFormatter : ColorArrayFormatter<HSLColor>() {

    override val regexes: Set<PrefixValueRegex> = setOf(
        PrefixValueRegex(PREFIX_HSL, "\\(${degree},${pctInt},${pctInt}\\)"),
        PrefixValueRegex(PREFIX_HSLA, "\\(${degree},${pctInt},${pctInt},${pctFlt}\\)"),
    )

    override fun serialize(color: HSLColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(prefix: String, value: String): HSLColor? {
        val sanitized = getValues(value, prefix == PREFIX_HSL)

        if (sanitized.size != 4) return null

        val hue = sanitized[0].toInt()
        val saturation = sanitized[1].toInt()
        val lightness = sanitized[2].toInt()
        val alpha = sanitized[3].toFloat()

        return HSLColor(hue, saturation, lightness, alpha)
    }
}