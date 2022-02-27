import java.util.Calendar

class DateUtil(private val number: Int, private val tense: Tense) {
    enum class Tense { ago, from_now }

    override fun toString(): String {
        val today = Calendar.getInstance()
        fun handleTense(t: Calendar, n: Int) { t.add(Calendar.DAY_OF_MONTH, n) }

        when (tense) {
            Tense.ago -> handleTense(today, -number)
            Tense.from_now -> handleTense(today, number)
        }

        return today.time.toString()
    }
}