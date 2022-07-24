package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.keepDecimalAndCoerceIn

abstract class ColorAlpha: IColor {

    private var _alpha: Float = 1f
    var alpha: Float
        get() = _alpha
        set(value) {
            _alpha = value.keepDecimalAndCoerceIn(2, 0f, 1f)
        }
    val alphaPct: Int
        get() = (alpha * 100).toInt().coerceIn(0, 100)

    constructor(alpha: Float) {
        this.alpha = alpha
    }

    open val formattedAlpha: String
        get() = alpha.toString()

    abstract fun toString(includeAlpha: Boolean): String

    override fun toString(): String {
        return toString(true)
    }
}