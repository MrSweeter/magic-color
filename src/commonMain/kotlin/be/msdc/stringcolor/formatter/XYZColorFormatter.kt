package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.XYZColor
import be.msdc.stringcolor.colors.XYZColor.Companion.PREFIX_XYZ
import be.msdc.stringcolor.colors.XYZColor.Companion.PREFIX_XYZA
import be.msdc.stringcolor.colors.XYZColor.Companion.XYZ_MAX_DECIMAL_PLACES

class XYZColorFormatter : ColorArrayFormatter<XYZColor>() {

    private val xyzDecimal = "([0-1]|(0?\\.[0-9]{1,$XYZ_MAX_DECIMAL_PLACES})|1\\.0{1,$XYZ_MAX_DECIMAL_PLACES})"

    override val regexes: Set<PrefixValueRegex> = setOf(
        PrefixValueRegex(PREFIX_XYZ, "\\(${xyzDecimal},${xyzDecimal},${xyzDecimal}\\)"),
        PrefixValueRegex(PREFIX_XYZA, "\\(${xyzDecimal},${xyzDecimal},${xyzDecimal},${pctFlt}\\)"),
    )

    override fun serialize(color: XYZColor, includeAlpha: Boolean): String {
        return color.toString(includeAlpha)
    }

    override fun deserialize(prefix: String, value: String): XYZColor? {
        val sanitized = getValues(value, prefix == PREFIX_XYZ)

        if (sanitized.size != 4) return null

        val x = sanitized[0].toFloat()
        val y = sanitized[1].toFloat()
        val z = sanitized[2].toFloat()
        val alpha = sanitized[3].toFloat()

        return XYZColor(x, y, z, alpha)
    }
}