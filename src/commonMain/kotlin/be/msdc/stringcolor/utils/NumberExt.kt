package be.msdc.stringcolor.utils

import kotlin.math.pow
import kotlin.math.roundToInt

fun Float.keepDecimal(count: Int): Float {
    val factor = 10f.pow(count)
    return (factor * this).roundToInt() / factor
}

fun Float.keepDecimalAndCoerceIn(count: Int, min: Float, max: Float): Float {
    return keepDecimal(count).coerceIn(min, max)
}

fun Int.coerceInDegree(): Int {
    val mod = this % 360
    return (if (mod < 0) (360 + mod) else mod).coerceIn(0, 360)
}

fun Int.padStart(radix: Int, length: Int): String {
    return toString(radix).padStart(length, '0')
}