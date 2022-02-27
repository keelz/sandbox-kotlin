class Point(x: Int, y: Int) {
    private val pair = Pair(x, y)
    private val firstSign = if (pair.first < 0) "" else "+"
    private val secondSign = if (pair.second < 0) "" else "+"
    override fun toString() = pair.pointToSecond()
    private fun Pair<Int, Int>.pointToSecond() = "${firstSign}${first}, ${this@Point.secondSign}${this.second}"
}