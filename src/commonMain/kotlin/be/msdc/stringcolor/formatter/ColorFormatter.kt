package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.IColor

interface ColorSerializer<T> where T: IColor {
    fun serialize(color: T, includeAlpha: Boolean): String
}

interface ColorDeserializer<T> where T: IColor {
    fun deserialize(string: String): T?
}

abstract class ColorFormatter<T>: ColorSerializer<T>, ColorDeserializer<T> where T: IColor {

    protected val PREFIX_GROUP_INDEX = 1
    protected val COLOR_GROUP_INDEX = 2

    protected val hex = "[0-9a-f]"
    protected val pctInt = "(0|[1-9][0-9]?|100)%?"
    protected val pctFlt = "(0|(0?\\.[0-9]{1,2})|1\\.0)"
    protected val bit8 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"
    protected val degree = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-9][0-9]|3[0-5][0-9]|360)"

    abstract val prefix: Regex
    abstract val regexes: Set<Regex>

    fun match(string: String): Boolean {
        return regexes.firstNotNullOfOrNull {
            it.matchEntire(sanitize(string))
        } != null
    }

    protected fun sanitize(color: String): String    {
        return color
            .trim()
            .lowercase()
            .replace(Regex("\\s"), "")
            .replace(Regex("°"), "")
            .replace(Regex("%"), "")
            .replace("1.0", "100") // 1.0 is the same as 100% in the regexes
            .replace(Regex("(\\D)(\\.\\d)")) { "${it.groupValues[1]}0${it.groupValues[2]}" } // replace .1 with 0.1
            .replace(Regex("(0\\.\\d+)")) { (it.value.toFloat() * 100).toInt().toString() } // replace 0.1 with 10
    }
}