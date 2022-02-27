class Meeting(private val title: String) {
    val start = StartTime()
    val end = EndTime()

    override fun toString() = "$title meeting starts at $start.time, ends by $end.time"
}

// does this String injection belong here?
infix fun String.meeting(process: Meeting.() -> Unit) {
    val meeting = Meeting(this)
    meeting.process()
    println(meeting)
}
