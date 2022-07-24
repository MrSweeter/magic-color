package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.keep2DecimalAndCoerceInPct
import be.msdc.stringcolor.utils.toPctInt

abstract class ColorAlpha : IColor {

    private var _alpha: Float = 1f
    var alpha: Float
        get() = _alpha
        set(value) {
            _alpha = value.keep2DecimalAndCoerceInPct()
        }
    val alphaPct: Int
        get() = alpha.toPctInt()

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