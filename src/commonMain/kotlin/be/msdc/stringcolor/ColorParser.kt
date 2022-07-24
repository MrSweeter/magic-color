package be.msdc.stringcolor

import be.msdc.stringcolor.colors.IColor
import be.msdc.stringcolor.formatter.*

object ColorParser {

    private val formatters by lazy { listOf(
        RGBColorFormatter(),
        HexadecimalColorFormatter(),
        //HSLColorFormatter(),
        //HSVColorFormatter(),
        //CMYKColorFormatter(),
    ) }

    fun parse(string: String): IColor? {
        return formatters.firstOrNull { it.match(string) }?.deserialize(string)
    }
}