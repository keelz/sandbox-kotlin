class PriorityPair<T: Comparable<T>>(member1: T, member2: T) {
    private val first: T
    private val second: T

    init {
        if (member1 >= member2) {
            first = member1
            second = member2
        } else {
            first = member2
            second = member1
        }
    }

    override fun toString(): String = "$first, $second"
}
