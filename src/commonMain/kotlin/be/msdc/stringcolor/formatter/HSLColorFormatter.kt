package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.HSLColor
import be.msdc.stringcolor.colors.HSLColor.Companion.PREFIX_HSL
import be.msdc.stringcolor.colors.HSLColor.Companion.PREFIX_HSLA

class HSLColorFormatter : ColorFormatter<HSLColor>() {

    override val prefix: Regex = Regex("(${PREFIX_HSL}|${PREFIX_HSLA})")

    override val regexes: Set<Regex> = setOf(
        Regex("(${PREFIX_HSL})(\\(${degree},${pctInt},${pctInt}\\))"), // hsl(hue,saturation,lightness)
        Regex("(${PREFIX_HSLA})(\\(${degree},${pctInt},${pctInt},${pctInt}\\))"), // hsla(hue,saturation,lightness,alpha)
    )

    override fun serialize(color: HSLColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(string: String): HSLColor? {
        val regexResult = regexes.firstNotNullOfOrNull {
            it.matchEntire(sanitize(string))
        } ?: return null

        val prefix = regexResult.groupValues[PREFIX_GROUP_INDEX]
        val value = regexResult.groupValues[COLOR_GROUP_INDEX]
        val sanitized = sanitizeColorValue(prefix, value)

        if (sanitized.size != 4) return null

        val hue = sanitized[0].toInt()
        val saturation = sanitized[1].toInt()
        val lightness = sanitized[2].toInt()
        val alpha = sanitized[3].toInt()

        return HSLColor(hue, saturation, lightness, alpha)
    }

    private fun sanitizeColorValue(prefix: String, value: String): List<String> {
        var sanitize = value.trim('(', ')').split(",")
        if (prefix == PREFIX_HSL) {
            sanitize = sanitize + "100"
        }
        return sanitize
    }
}