class Animal(val age: Int) {
    override operator fun equals(other: Any?) = other is Animal && age == other.age

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
