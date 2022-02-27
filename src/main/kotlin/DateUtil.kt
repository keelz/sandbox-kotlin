import java.util.Calendar

class DateUtil(private val number: Int, private val tense: Tense) {
    enum class Tense { ago, from_now }

    override fun toString(): String {
        val today = Calendar.getInstance()

        when (tense) {
            Tense.ago -> today.add(Calendar.DAY_OF_MONTH, -number)
            Tense.from_now -> today.add(Calendar.DAY_OF_MONTH, number)
        }

        return today.time.toString()
    }
}