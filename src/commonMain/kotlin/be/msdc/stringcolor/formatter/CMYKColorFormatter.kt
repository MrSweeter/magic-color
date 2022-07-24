package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.CMYKColor
import be.msdc.stringcolor.colors.CMYKColor.Companion.PREFIX_CMYK
import be.msdc.stringcolor.colors.CMYKColor.Companion.PREFIX_CMYKA

class CMYKColorFormatter : ColorFormatter<CMYKColor>() {

    override val prefix: Regex = Regex("(${PREFIX_CMYK}|${PREFIX_CMYKA})")

    override val regexes: Set<Regex> = setOf(
        Regex("(${PREFIX_CMYK})(\\(${pctInt},${pctInt},${pctInt},${pctInt}\\))"), // cmyk(c,m,y,k)
        Regex("(${PREFIX_CMYKA})(\\(${pctInt},${pctInt},${pctInt},${pctInt},${pctInt}\\))"), // cmyka(c,m,y,k,a)
    )

    override fun serialize(color: CMYKColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(string: String): CMYKColor? {
        val regexResult = regexes.firstNotNullOfOrNull {
            it.matchEntire(sanitize(string))
        } ?: return null

        val prefix = regexResult.groupValues[PREFIX_GROUP_INDEX]
        val value = regexResult.groupValues[COLOR_GROUP_INDEX]
        val sanitized = sanitizeColorValue(prefix, value)

        if (sanitized.size != 5) return null

        val cyan = sanitized[0].toInt()
        val magenta = sanitized[1].toInt()
        val yellow = sanitized[2].toInt()
        val key = sanitized[3].toInt()
        val alpha = sanitized[4].toInt()

        return CMYKColor(cyan, magenta, yellow, key, alpha)
    }

    private fun sanitizeColorValue(prefix: String, value: String): List<String> {
        var sanitize = value
            .trim('(', ')').split(",")
        if (prefix == PREFIX_CMYK) {
            sanitize = sanitize + "100"
        }
        return sanitize
    }
}