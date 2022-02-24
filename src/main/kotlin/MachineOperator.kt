class MachineOperator(val name: String) {
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--

    // companion object as a factory
    companion object MachineOperatorFactory {
        var checkedIn = 0

        fun create(name: String): MachineOperator {
            val instance = MachineOperator(name)
            instance.checkin()
            return instance
        }
        fun minimumBreak() = "15 minutes every 2 hours"
    }
}