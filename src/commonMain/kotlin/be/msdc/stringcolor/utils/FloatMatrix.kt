package be.msdc.stringcolor.utils

class FloatMatrix(private val matrixArray: List<List<Float>>) {

    private val columnCount get() = matrixArray[0].size
    private val rowCount get() = matrixArray.size

    fun get(row: Int = 0, column: Int = 0): Float {
        return matrixArray.getOrNull(row)?.getOrNull(column) ?: 0f
    }

    operator fun times(other: FloatMatrix): FloatMatrix {
        return multiply(other)
    }

    private fun multiply(other: FloatMatrix): FloatMatrix {
        if (this.columnCount != other.rowCount) {
            throw IllegalArgumentException("Column count of first matrix must be equal to row count of second matrix")
        }

        val result = List(rowCount) { MutableList(other.columnCount) { 0f } }

        for (i in matrixArray.indices) {
            for (j in other.matrixArray[0].indices) {
                for (k in matrixArray[0].indices) {
                    val ik = matrixArray[i][k]
                    val kj = other.matrixArray[k][j]
                    result[i][j] += ik * kj
                }
            }
        }

        return FloatMatrix(result)
    }
}