package be.msdc.stringcolor.colors

import be.msdc.stringcolor.utils.FloatMatrix
import be.msdc.stringcolor.utils.Illuminant
import be.msdc.stringcolor.utils.keepDecimal
import kotlin.math.pow
import kotlin.math.roundToInt

// The XYZ model is a color model with 3 components that are used to model human color vision on a basic sensory level.
// https://fr.wikipedia.org/wiki/CIE_XYZ
// https://www.oceanopticsbook.info/view/photometry-and-visibility/from-xyz-to-rgb

class XYZColor(x: Float, y: Float, z: Float, alpha: Float = 1f): ColorAlpha(alpha) {

    private var _x: Float = 0f
    var x: Float
        get() = _x
        set(value) {
            _x = value.coerceIn(0f, Illuminant.D65_10.x)
        }

    private var _y: Float = 0f
    var y: Float
        get() = _y
        set(value) {
            _y = value.coerceIn(0f, Illuminant.D65_10.y)
        }

    private var _z: Float = 0f
    var z: Float
        get() = _z
        set(value) {
            _z = value.coerceIn(0f, Illuminant.D65_10.z)
        }

    init {
        this.x = x
        this.y = y
        this.z = z
    }

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
        val xyzMatrix = FloatMatrix(listOf(
            listOf(x),
            listOf(y),
            listOf(z)
        ))
        val rgbMatrix = xyzToRgbMatrix * xyzMatrix
        return RGBColor(
            (rgbMatrix.get(row = 0) * 255).roundToInt(),
            (rgbMatrix.get(row = 1) * 255).roundToInt(),
            (rgbMatrix.get(row = 2) * 255).roundToInt(),
            alpha
        )
    }

    override fun toLAB(): LABColor {
        // 0.008856 Actual CIE standard
        // 216 / 24389 Intent of the CIE standard
        val epsilon = 216 / 24389
        // 903.3 Actual CIE standard
        // 24389 / 27 Intent of the CIE standard
        val kappa = 24389 / 27

        val fx = this.x / Illuminant.D65_10.x
        val fy = this.y / Illuminant.D65_10.y
        val fz = this.z / Illuminant.D65_10.z

        val x0 = if (fx > epsilon) fx.pow(1 / 3) else (kappa * fx + 16) / 116f
        val y0 = if (fy > epsilon) fy.pow(1 / 3) else (kappa * fy + 16) / 116f
        val z0 = if (fz > epsilon) fz.pow(1 / 3) else (kappa * fz + 16) / 116f

        return LABColor(
            100 * (116 * y - 16),
            500 * (x0 - y0) * 100,
            200 * (y0 - z0) * 100,
            alpha
        )
    }

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