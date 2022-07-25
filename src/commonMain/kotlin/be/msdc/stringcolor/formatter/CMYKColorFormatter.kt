package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.CMYKColor
import be.msdc.stringcolor.colors.CMYKColor.Companion.PREFIX_CMYK
import be.msdc.stringcolor.colors.CMYKColor.Companion.PREFIX_CMYKA

class CMYKColorFormatter : ColorArrayFormatter<CMYKColor>() {

    override val regexes: Set<PrefixValueRegex> = setOf(
        PrefixValueRegex(PREFIX_CMYK, "\\(${pctInt},${pctInt},${pctInt},${pctInt}\\)"),
        PrefixValueRegex(PREFIX_CMYKA, "\\(${pctInt},${pctInt},${pctInt},${pctInt},${pctFlt}\\)"),
    )

    override fun serialize(color: CMYKColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(prefix: String, value: String): CMYKColor? {
        val values = getValues(value, prefix == PREFIX_CMYK)

        if (values.size != 5) return null

        val cyan = values[0].toInt()
        val magenta = values[1].toInt()
        val yellow = values[2].toInt()
        val key = values[3].toInt()
        val alpha = values[4].toFloat()

        return CMYKColor(cyan, magenta, yellow, key, alpha)
    }
}