import kotlin.math.roundToInt

fun main() {
    mapExample()
//    listComposition()
//    anonymousArray()
//    arrayOfStuff()
//    tupleExample()
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
    fun pf (fruit: String) = println("\t$fruit")
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
    println("** tupleExample **")
    val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
    val temperatures = airportCodes.map { code -> code to getTemperatureAtAirport(code) } // to operator composes a tuple from left and right operands
    temperatures.iterator().forEach { temp ->
        println("\tAirport: ${temp.first}: Temperature: ${temp.second}")
    }
}

fun getTemperatureAtAirport(code: String): String = "${(Math.random() * 30).roundToInt() + code.count()} C"