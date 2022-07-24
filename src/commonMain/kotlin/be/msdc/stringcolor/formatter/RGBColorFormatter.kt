package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.RGBColor
import be.msdc.stringcolor.colors.RGBColor.Companion.PREFIX_RGB
import be.msdc.stringcolor.colors.RGBColor.Companion.PREFIX_RGBA

class RGBColorFormatter : ColorFormatter<RGBColor>() {

    override val prefix: Regex = Regex("(${PREFIX_RGB}|${PREFIX_RGBA})")

    override val regexes: Set<Regex> = setOf(
        Regex("(${PREFIX_RGB})(\\(${bit8},${bit8},${bit8}\\))"), // rgb(r,g,b)
        Regex("(${PREFIX_RGBA})(\\(${bit8},${bit8},${bit8},${pctInt}\\))"), // rgba(r,g,b,a)
        Regex("(${PREFIX_RGBA})(\\(${bit8},${bit8},${bit8},${pctFlt}\\))"), // rgba(r,g,b,.a)
    )

    override fun serialize(color: RGBColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(string: String): RGBColor? {
        val regexResult = regexes.firstNotNullOfOrNull {
            it.matchEntire(sanitize(string))
        } ?: return null

        val prefix = regexResult.groupValues[PREFIX_GROUP_INDEX]
        val value = regexResult.groupValues[COLOR_GROUP_INDEX]
        val sanitized = sanitizeColorValue(prefix, value)
        println("sanitized: $sanitized")

        if (sanitized.size != 4) return null

        val red = sanitized[0].toInt()
        val green = sanitized[1].toInt()
        val blue = sanitized[2].toInt()
        val alpha = sanitized[3].toInt()

        return RGBColor(red, green, blue, alpha)
    }

    private fun sanitizeColorValue(prefix: String, value: String): List<String> {
        var sanitize = value.trim('(', ')').split(",")
        if (prefix == PREFIX_RGB) {
            sanitize = sanitize + "100"
        }
        return sanitize
    }
}