package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.HSVColor
import be.msdc.stringcolor.colors.HSVColor.Companion.PREFIX_HSB
import be.msdc.stringcolor.colors.HSVColor.Companion.PREFIX_HSBA
import be.msdc.stringcolor.colors.HSVColor.Companion.PREFIX_HSV
import be.msdc.stringcolor.colors.HSVColor.Companion.PREFIX_HSVA

class HSVColorFormatter : ColorArrayFormatter<HSVColor>() {

    override val regexes: Set<PrefixValueRegex> = setOf(
        PrefixValueRegex(PREFIX_HSV, "\\(${degree},${pctInt},${pctInt}\\)"),
        PrefixValueRegex(PREFIX_HSB, "\\(${degree},${pctInt},${pctInt}\\)"),
        PrefixValueRegex(PREFIX_HSVA, "\\(${degree},${pctInt},${pctInt},${pctFlt}\\)"),
        PrefixValueRegex(PREFIX_HSBA, "\\(${degree},${pctInt},${pctInt},${pctFlt}\\)"),
    )

    override fun serialize(color: HSVColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(prefix: String, value: String): HSVColor? {
        val sanitized = getValues(value, prefix == PREFIX_HSV)

        if (sanitized.size != 4) return null

        val hue = sanitized[0].toInt()
        val saturation = sanitized[1].toInt()
        val v = sanitized[2].toInt()
        val alpha = sanitized[3].toFloat()

        return HSVColor(hue, saturation, v, alpha)
    }
}