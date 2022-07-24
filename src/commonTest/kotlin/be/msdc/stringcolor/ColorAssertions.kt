package be.msdc.stringcolor

import be.msdc.stringcolor.colors.IColor
import be.msdc.stringcolor.colors.isSameColor
import kotlin.test.Asserter
import kotlin.test.assertIs
import kotlin.test.asserter

internal fun <T> assertSameColor(expected: T, actual: T, message: String? = null) {
    asserter.assertSameColor(message, expected, actual)
}

internal fun Asserter.assertSameColor(message: String?, expected: Any?, actual: Any?) {
    assertIs<IColor>(
        actual,
        "Expected actual is ${IColor::class.qualifiedName} inheritance but was ${actual?.let { it::class.qualifiedName }}"
    )
    assertIs<IColor>(
        expected,
        "Expected expected is ${IColor::class.qualifiedName} inheritance but was ${expected?.let { it::class.qualifiedName }}"
    )
    assertTrue({ messagePrefix(message) + "Expected <$expected>, actual <$actual>." }, actual.isSameColor(expected))
}

internal fun messagePrefix(message: String?) = if (message == null) "" else "$message. "