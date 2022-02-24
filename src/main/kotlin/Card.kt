sealed class Card(val suit: Suit)

class Ace(suit: Suit) : Card(suit)

class King(suit: Suit) : Card(suit) {
    override fun toString() = "king of $suit"
}

class Queen(suit: Suit) : Card(suit) {
    override fun toString() = "queen of $suit"
}

class Jack(suit: Suit) : Card(suit) {
    override fun toString() = "jack of $suit"
}

class Pip(suit: Suit, val number: Int) : Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw java.lang.RuntimeException("pip has to be between 2 and 10")
        }
    }
}