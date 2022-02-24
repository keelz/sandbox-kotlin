import util.*
import util.Temperature.c2f
import java.lang.Appendable
import kotlin.math.roundToInt

fun main() {
    withCards()
}

fun withCards() {
    fun process(card: Card) = when(card) {
        is Ace -> "${card.javaClass.name} of ${card.suit}"
        is King, is Queen, is Jack -> "$card"
        is Pip -> "${card.number} of ${card.suit}"
    }

    println(process(Ace(Suit.DIAMONDS)))
    println(process(Queen(Suit.HEARTS)))
    println(process(Pip(Suit.CLUBS, 2)))
    println(process(Pip(Suit.SPADES, 6)))
}

fun useTask() {
    val task1 = Task(1, "create project", completed = false, assigned = true)
    val task1Completed = task1.copy(completed = true, assigned = false)
    println(task1Completed)
    println(task1Completed.name)

    val (id, _, _, isAssigned) = task1
    println("Id: $id Assigned: $isAssigned")
}

fun useComparable() {
    println(PriorityPair(2, 1))
    println(PriorityPair("A", "B"))
}

fun useMachineOperator() {
    // this is probably the weirdest code I've ever seen
    MachineOperator.create("mo")
    println(MachineOperator.checkedIn)
}

@JvmInline
value class SSN(val id: String)

fun receiveSSN(ssn: SSN) {
    println("Received $ssn")
}

fun useCar() {
    val car = Car(2019, "Red")
    car.color = "blue"
    println(car.color)
    car.color = "green"
    println(car.color)
}

fun useUtil() {
    println(unitsSupported())
    println(Temperature.f2c(75.253))
    println(c2f(24.305))
    println()
}

object Sun: Runnable {
    val radiusInKM = 696000
    var coreTemperatureInC = 1500000
    override fun run() {
        TODO("Not yet implemented")
    }
}

object Util {
    val name: String = "bullshit"
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
}

fun createRunnableThree(): Runnable = object: Runnable, AutoCloseable {
    override fun run() {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }
}

fun createRunnableTwo(): Runnable = Runnable { println("you called...") }

fun createRunnable(): Runnable {
    // verbose
    val runnable = object : Runnable {
        override fun run() {
            TODO("Not yet implemented")
        }
    }
    runnable.run()
    // inline with lambda
    // If the interface implemented by the anonymous inner class is a single abstract method interface
    // (what Java 8 calls a functional interface), then we can directly provide the implementation without
    // the need to specify the method name
    return Runnable { TODO("Not yet implemented") }
}

fun drawCircle() {
    val circle = object {
        val x = 10
        val y = 20
        val radius = 30
    }
}

// findFirst
// - helper method for booksBooks
// - 'filter' implementation with generics
inline fun <reified T> findFirst(books: List<Book>): T {
    val selected = books.filter { book -> book is T }
    if (selected.isEmpty()) {
        throw java.lang.RuntimeException("Not Found")
    }
    return selected[0] as T
}

// booksBooks
// - use of generics with a 'filter' to reduce list of objects.
fun booksBooks() {
    val books: List<Book> = listOf(
        Fiction("Moby Dick"),
        NonFiction("Learn to Code"),
        Fiction("LOTR")
    )
    println(findFirst<NonFiction>(books).name)
}

// starProjection
// - use of star project to permit only read-out and not write-in
fun starProjection(values: Array<*>) {
    for (value in values) {
        println(value)
    }
    // values[0] = values[1] //ERROR
}

// helloThere
// - use of 'where' to implement parametric type conform to AutoClosable and Appendable
fun helloThere() {
    fun <T> useAndClose(input: T)
            where T : AutoCloseable,
                  T : Appendable {
        input.append("there")
        input.close()
    }

    val writer = java.io.StringWriter()
    writer.append("hello ")
    useAndClose(writer)
    println(writer)
}

fun copyCopy() {
    val fruitsBasket1 = Array<Banana>(3) { _ -> Banana() }
    val fruitsBasket2 = Array<Any>(3) { _ -> Orange() }
    copyFromTo(fruitsBasket1, fruitsBasket2)
}

fun copyFromTo(from: Array<out Fruit>, to: Array<in Fruit>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun playWithFruit() {
    val bananas: List<Banana> = listOf()
    receiveFruits(bananas)
}

fun receiveFruits(fruits: List<Fruit>) {
    println("Number of fruits: ${fruits.size}")
}

// explicitSafeTypeCasting
// - use of 'as?' to safely type cast a String
fun explicitSafeTypeCasting() {
    fun fetchMessage(id: Int): Any = if (id == 1) "Record found" else java.lang.StringBuilder("data not found")
    println("Message length: ${(fetchMessage(1) as? String)?.length ?: "---"}")
}

// whatToDo
// - use of 'is' in 'when' expression to gain automatic type casting
fun whatToDo(dayOfWeek: Any) = when (dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard"
    in 2..4 -> "Work hard"
    is String -> "What, you provided a string of length ${dayOfWeek.length}"
    else -> "No clue"
}

// overrideEquals
// - use a class that overrides the 'equals' Object method
// - use of 'is' keyword to check type and gain automatic type casting
fun overrideAEquals() {
    val odie: Any = Animal(2)
    val toto: Any = Animal(2)
    val butch = Animal(3)
    println(odie == toto)
    println(odie == butch)
}

// mapExample
// - use of the 'to' operator to compose a map
// - use of {map}.values.forEach to iterate over the values of a map
// - use of {map}.keys.forEach to iterate over the keys of a map
// - use of {map}.keys.sorted.foreach to iterate over a sorted list of map keys
// - use of 'for ((key, value) in {map})' to iterate over keys and values of a map
fun mapExample() {
    println("** mapExample **")
    val sites = mapOf<String, String>(
        "pragprog" to "https://www.pragprog.com",
        "agiledeveloper" to "https://agiledeveloper.com",
    )
    println("\tsize of sites map is ${sites.size}") // 2
    sites.keys
        .sorted()
        .forEach { k -> println("\t[$k]: ${sites[k]}") }
    sites.values.forEach { v -> println("\tvalue: $v") }
    sites.keys.forEach { k ->
        when (val x: String? = sites[k]) {
            null -> println("\tsites key $k not found")
            else -> println("\t$k = $x")
        }
    }
    for ((k, v) in sites) {
        println("\t[$k]: $v")
    }
    println("\tsites map contains 'pragprog' key: ${sites.containsKey("pragprog")}")
    println("\tsites map contains 'https://www.pragprog.com' value: ${sites.containsValue("https://www.pragprog.com")}")
}

// listComposition()
// - use of '+' and '-' operators to demonstrate immutable list composition
fun listComposition() {
    fun pf(fruit: String) = println("\t$fruit")
    println("** listComposition **")
    val fruits = listOf<String>("apple", "Orange", "tomato")
    fruits.iterator().forEach { f -> pf(f) }
    println("\t**")
    val fruits2 = fruits + "banana"
    fruits2.iterator().forEach { f -> pf(f) }
    println("\t**")
    val fruits3 = fruits - "banana"
    fruits3.iterator().forEach { f -> pf(f) }
}

// anonymousArray()
// - use of an anonymous array to iterate over a literal number of elements within the array
// - use of 'sum' method as an array reducer/collector to compose a single value from elements of the array
fun anonymousArray() {
    println("** anonymousArray **")
    println("\t${IntArray(5) { i -> (i + 1) * (i + 1) }.sum()}")
}

// arrayOfStuff
// - arrays can be of mixed type
// - traditional use of [] index syntax
fun arrayOfStuff() {
    println("** arrayOfStuff **")
    val friends = arrayOf("Tintin", 1, "Haddock", "Calculus")
    println("\t${friends[0]} and ${friends[1]} and ${friends[2]}")
}

// tupleExample
// - use of 'to' operator to create a tuple from left and right operands
// - use of 'iterator' api to loop through values of a list<R>
fun tupleExample() {
    fun getTemperatureAtAirport(code: String): String = "${(Math.random() * 30).roundToInt() + code.count()} C"
    println("** tupleExample **")
    val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
    val temperatures =
        airportCodes.map { code -> code to getTemperatureAtAirport(code) } // to operator composes a tuple from left and right operands
    temperatures.iterator().forEach { temp ->
        println("\tAirport: ${temp.first}: Temperature: ${temp.second}")
    }
}

// isAlive
// - example of 'when' expression
fun isAlive(alive: Boolean, numberOfLiveNeighbors: Int) = when {
    numberOfLiveNeighbors < 2 -> false
    numberOfLiveNeighbors > 3 -> false
    numberOfLiveNeighbors == 3 -> true
    else -> alive && numberOfLiveNeighbors == 2
}

// printWhatToDo
// - example of 'when' expression
fun printWhatToDo(dayOfWeek: Any) {
    when (dayOfWeek) {
        "Saturday", "Sunday" -> println("Relax")
        in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> println("work hard")
        in 2..4 -> println("work hard")
        is String -> println("what?")
    }
}

fun systemInfo(): String = when (val numberOfCores = Runtime.getRuntime().availableProcessors()) {
    1 -> "1 core, packing this one to the museum"
    in 2..16 -> "You have $numberOfCores cores"
    else -> "$numberOfCores cores!, I want your machine!"
}

fun greet(name: String, weight: Int = 250, age: Int, vararg stuff: String) =
    "hello $name is $age years old and weighs $weight lbs ${stuff.joinToString(separator = " ")}."
