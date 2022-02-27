import kotlin.math.abs

data class Complex(val real: Int, val imaginary: Int) {
    // overload '*' operator
    operator fun times(other: Complex) = Complex(
        real * other.real - imaginary * other.imaginary,
        real * other.imaginary + imaginary * other.real
    )

    // overload '/' operator
    operator fun div(other: Complex) = Complex(
        real / other.real,
        imaginary / other.imaginary
    )

    private fun sign() = if (imaginary < 0) "-" else "+"

    override fun toString() = "$real ${sign()} ${abs(imaginary)}"
}