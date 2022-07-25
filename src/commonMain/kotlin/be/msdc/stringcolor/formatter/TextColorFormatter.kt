package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.RGBColor
import be.msdc.stringcolor.colors.TextColor

class TextColorFormatter : ColorFormatter<RGBColor>() {

    override val regexes: Set<PrefixValueRegex> = setOf(
        PrefixValueRegex("", TextColor.values().joinToString("|") { it.raw })
    )

    override fun serialize(color: RGBColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(prefix: String, value: String): RGBColor? {
        return TextColor.fromString(value)
    }
}