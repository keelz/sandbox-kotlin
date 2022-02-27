open class MeetingTime(var time: String = "") {
    protected fun convertToString(time: Double) = String.format("%.02f", time)
}

class StartTime : MeetingTime() {
    infix fun at(theTime: Double) { time = convertToString(theTime) }
}

class EndTime : MeetingTime() {
    infix fun by(theTime: Double) { time = convertToString(theTime) }
}
