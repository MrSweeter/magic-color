package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.FloatMatrix
import be.msdc.stringcolor.utils.keepDecimal
import kotlin.math.roundToInt

// The XYZ model is a color model with 3 components that are used to model human color vision on a basic sensory level.
// https://fr.wikipedia.org/wiki/CIE_XYZ
// https://www.oceanopticsbook.info/view/photometry-and-visibility/from-xyz-to-rgb

class XYZColor(var x: Float, var y: Float, var z: Float, alpha: Float = 1f): ColorAlpha(alpha) {

    val formattedX
        get() = x.keepDecimal(XYZ_MAX_DECIMAL_PLACES).toString()
    val formattedY
        get() = y.keepDecimal(XYZ_MAX_DECIMAL_PLACES).toString()
    val formattedZ
        get() = z.keepDecimal(XYZ_MAX_DECIMAL_PLACES).toString()

    override fun toString(includeAlpha: Boolean): String {
        if (includeAlpha) return "$PREFIX_XYZA($formattedX, $formattedY, $formattedZ, $formattedAlpha)"
        return "$PREFIX_XYZ($formattedX, $formattedY, $formattedZ)"
    }

    override fun toRGB(): RGBColor {
        val rgbMatrix = xyzToRgbMatrix * xyzMatrix
        println(rgbMatrix)
        return RGBColor(
            (rgbMatrix.get(row = 0) * 255).roundToInt(),
            (rgbMatrix.get(row = 1) * 255).roundToInt(),
            (rgbMatrix.get(row = 2) * 255).roundToInt(),
            alpha
        )
    }

    private val xyzMatrix: FloatMatrix
        get() = FloatMatrix(listOf(
            listOf(x),
            listOf(y),
            listOf(z)
        ))

    companion object {
        const val PREFIX_XYZ = "xyz"
        const val PREFIX_XYZA = "xyza"
        const val XYZ_MAX_DECIMAL_PLACES = 5

        val xyzToRgbMatrix: FloatMatrix by lazy {
            FloatMatrix(listOf(
                listOf(3.2404542f, -1.5371385f, -0.4985314f),
                listOf(-0.9692660f, 1.8760108f, 0.0415560f),
                listOf(0.0556434f, -0.2040259f, 1.0572252f)
            ))
        }
        val rgbToXyzMatrix: FloatMatrix by lazy {
            FloatMatrix(listOf(
                listOf(0.4124564f, 0.3575761f, 0.1804375f),
                listOf(0.2126729f, 0.7151522f, 0.0721750f),
                listOf(0.0193339f, 0.1191920f, 0.9503041f)
            ))
        }

        fun fromRGB(rgbColor: RGBColor): XYZColor {
            val rgbMatrix = FloatMatrix(listOf(
                listOf(rgbColor.red / 255f),
                listOf(rgbColor.green / 255f),
                listOf(rgbColor.blue / 255f)
            ))
            val xyzMatrix = rgbToXyzMatrix * rgbMatrix
            return XYZColor(
                xyzMatrix.get(row = 0),
                xyzMatrix.get(row = 1),
                xyzMatrix.get(row = 2),
                rgbColor.alpha
            )
        }
    }
}