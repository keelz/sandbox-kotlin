class TV {
    private var volume = 0

    val remote: Remote get() = object: Remote {
        override fun up() { volume++ }
        override fun down() { volume-- }
        override fun toString() = "remote: ${this@TV.toString()}"
    }

    override fun toString(): String = "volume: $volume"
}