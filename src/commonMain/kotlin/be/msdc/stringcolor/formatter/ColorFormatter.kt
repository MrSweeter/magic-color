package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.IColor

interface ColorSerializer<T> where T : IColor {
    fun serialize(color: T, includeAlpha: Boolean): String
}

interface ColorDeserializer<T> where T : IColor {
    fun deserialize(string: String): T?
    fun deserialize(prefix: String, value: String): T?
}

abstract class ColorFormatter<T> : ColorSerializer<T>, ColorDeserializer<T> where T : IColor {

    private val PREFIX_GROUP_INDEX = 1
    private val COLOR_GROUP_INDEX = 2

    protected val hex = "[0-9a-f]"
    protected val pctInt = "(0|[1-9][0-9]?|100)%?"
    protected val pctFlt = "([0-1]|(0?\\.[0-9]{1,2})|1\\.0)"
    protected val bit8 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"
    protected val degree = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-9][0-9]|3[0-5][0-9]|360)"

    abstract val prefix: Regex
    abstract val regexes: Set<Regex>

    fun match(string: String): Boolean {
        return regexes.any { it.matches(sanitize(string)) }
    }

    override fun deserialize(string: String): T? {
        val regexResult = regexes.firstNotNullOfOrNull { it.matchEntire(sanitize(string)) } ?: return null
        val prefix = regexResult.groupValues[PREFIX_GROUP_INDEX]
        val value = regexResult.groupValues[COLOR_GROUP_INDEX]
        return deserialize(prefix, value)
    }

    private fun sanitize(color: String): String {
        return color
            .trim()
            .lowercase()
            .replace(Regex("\\s"), "")
            .replace(Regex("°"), "")
            .replace(Regex("%"), "")
    }
}