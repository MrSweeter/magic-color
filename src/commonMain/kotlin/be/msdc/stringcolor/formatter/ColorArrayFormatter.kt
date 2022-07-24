package be.msdc.stringcolor.formatter

import be.msdc.stringcolor.colors.IColor

abstract class ColorArrayFormatter<T> : ColorFormatter<T>() where T : IColor {

    protected fun getValues(value: String, addAlpha: Boolean): List<String> {
        var values = value.trim('(', ')').split(",")
        if (addAlpha) {
            values = values.plus("1.0")
        }
        return values
    }

}