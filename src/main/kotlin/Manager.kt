class Manager(val staff: Worker) : Worker by staff {
    fun meeting() = println("organizing meeting with ${staff.javaClass.simpleName}")

    override fun takeVacation() = println("of course")
}
