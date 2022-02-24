sealed class Card(val suit: String)

class Ace(suit: String) : Card(suit)

class King(suit: String) : Card(suit) {
    override fun toString() = "king of $suit"
}

class Queen(suit: String) : Card(suit) {
    override fun toString() = "queen of $suit"
}

class Jack(suit: String) : Card(suit) {
    override fun toString() = "jack of $suit"
}

class Pip(suit: String, val number: Int) : Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw java.lang.RuntimeException("pip has to be between 2 and 10")
        }
    }
}