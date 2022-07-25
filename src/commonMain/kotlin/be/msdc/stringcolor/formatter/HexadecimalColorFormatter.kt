package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.HexadecimalColor

class HexadecimalColorFormatter : ColorFormatter<HexadecimalColor>() {

    private val prefixPattern: String = "${HexadecimalColor.PREFIX_HEX}|${HexadecimalColor.PREFIX_HEX_X}"

    override val regexes: Set<PrefixValueRegex> = setOf(
        PrefixValueRegex(prefixPattern, "$hex{3}"),
        PrefixValueRegex(prefixPattern, "$hex{4}"),
        PrefixValueRegex(prefixPattern, "$hex{6}"),
        PrefixValueRegex(prefixPattern, "$hex{8}"),
    )

    override fun serialize(color: HexadecimalColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(prefix: String, value: String): HexadecimalColor? {
        val sanitized = sanitizeColorValue(value)

        if (sanitized.length != 8) return null

        val alpha = sanitized.substring(0, 2).toInt(16) / 255f
        val red = sanitized.substring(2, 4).toInt(16)
        val green = sanitized.substring(4, 6).toInt(16)
        val blue = sanitized.substring(6, 8).toInt(16)

        return HexadecimalColor(red, green, blue, alpha)
    }

    private fun sanitizeColorValue(value: String): String {
        var sanitize = value
        if (sanitize.length == 3 || sanitize.length == 4) {
            sanitize = sanitize.map { "$it$it" }.joinToString("")
        }
        if (sanitize.length == 6) {
            sanitize = "ff${sanitize}"
        }
        return sanitize
    }
}