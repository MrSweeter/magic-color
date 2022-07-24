package be.msdc.stringcolor.utils

import kotlin.math.pow
import kotlin.math.roundToInt

fun Float.keepDecimal(count: Int): Float {
    val factor = 10f.pow(count)
    return (factor * this).roundToInt() / factor
}

fun Float.keep2DecimalAndCoerceInPct(): Float {
    return keepDecimal(2).coerceIn(0f, 1f)
}

fun Float.toPctInt(): Int {
    return (keep2DecimalAndCoerceInPct() * 100).roundToInt()
}

fun Int.coerceInDegree(): Int {
    val mod = this % 360
    return (if (mod < 0) (360 + mod) else mod).coerceIn(0, 360)
}

fun Int.coerceInPct(): Int {
    return this.coerceIn(0, 100)
}

fun Int.padStart(radix: Int, length: Int): String {
    return toString(radix).padStart(length, '0')
}