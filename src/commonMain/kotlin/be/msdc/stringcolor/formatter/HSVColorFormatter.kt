package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.HSVColor
import be.msdc.stringcolor.colors.HSVColor.Companion.PREFIX_HSB
import be.msdc.stringcolor.colors.HSVColor.Companion.PREFIX_HSBA
import be.msdc.stringcolor.colors.HSVColor.Companion.PREFIX_HSV
import be.msdc.stringcolor.colors.HSVColor.Companion.PREFIX_HSVA

class HSVColorFormatter : ColorFormatter<HSVColor>() {

    override val prefix: Regex = Regex("(${PREFIX_HSV}|${PREFIX_HSVA}|${PREFIX_HSB}|${PREFIX_HSBA})")

    override val regexes: Set<Regex> = setOf(
        Regex("(${PREFIX_HSV})(\\(${degree},${pctInt},${pctInt}\\))"), // hsv(hue,saturation,value)
        Regex("(${PREFIX_HSB})(\\(${degree},${pctInt},${pctInt}\\))"), // hsb(hue,saturation,value)
        Regex("(${PREFIX_HSVA})(\\(${degree},${pctInt},${pctInt},${pctInt}\\))"), // hsva(hue,saturation,value,alpha)
        Regex("(${PREFIX_HSBA})(\\(${degree},${pctInt},${pctInt},${pctInt}\\))"), // hsba(hue,saturation,value,alpha)
    )

    override fun serialize(color: HSVColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(string: String): HSVColor? {
        val regexResult = regexes.firstNotNullOfOrNull {
            it.matchEntire(sanitize(string))
        } ?: return null

        val prefix = regexResult.groupValues[PREFIX_GROUP_INDEX]
        val colorValue = regexResult.groupValues[COLOR_GROUP_INDEX]
        val sanitized = sanitizeColorValue(prefix, colorValue)

        if (sanitized.size != 4) return null

        val hue = sanitized[0].toInt()
        val saturation = sanitized[1].toInt()
        val value = sanitized[2].toInt()
        val alpha = sanitized[3].toInt()

        return HSVColor(hue, saturation, value, alpha)
    }

    private fun sanitizeColorValue(prefix: String, value: String): List<String> {
        var sanitize = value.trim('(', ')').split(",")
        if (prefix == PREFIX_HSV) {
            sanitize = sanitize + "100"
        }
        return sanitize
    }
}