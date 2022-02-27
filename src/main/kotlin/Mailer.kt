class Mailer {
    private val details = StringBuilder()
    fun from(addr: String): StringBuilder = details.append("from $addr...\n")
    fun to(addr: String): StringBuilder = details.append("to $addr...\n")
    fun subject(line: String): StringBuilder = details.append("subject $line...\n")
    fun body(message: String): StringBuilder = details.append("body $message...\n")
    fun send() = "...sending...\n$details"
}