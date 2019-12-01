
class Aquarium(var length:Int = 10, var width: Int = 20, var height: Int = 5) {

    constructor(numberOfFish: Int): this()
    /**
     * Override the getter and setters.
     * getter returns the volume, setter set the height based on amount of water that tank should hold.
     */
    var volume : Int
        get() = length * width * height / 1000
        set(value) { height = (value/1000) / width * length}
}

class Fish(val firendly: Boolean = true, volumnNeeded: Int) {
    val size:Int = if (firendly) {
        volumnNeeded
    } else {
        volumnNeeded * 2
    }
}

fun fishCalled() {
    val fishData = Fish(true, 3)
    println("is fish friendly : ${fishData.firendly} and required size: ${fishData.size}")
}

fun main() {
    //val food: SimpleSpice = SimpleSpice()
    val spices1 = listOf(
        SimpleSpice("curry", "mild"),
        SimpleSpice("pepper", "medium"),
        SimpleSpice("cayenne", "spicy"),
        SimpleSpice("ginger", "mild"),
        SimpleSpice("red curry", "medium"),
        SimpleSpice("green curry", "mild"),
        SimpleSpice("hot pepper", "extremely spicy")
    )

    println(spices1.filter { it.heat < 5})

    /*println("Name : ${food.name}")
    println("Spiciness: ${food.heat}")*/
}
class SimpleSpice(val name: String, val spiciness: String = "mild") {
    //suspecious var property, it's setter does not influence it's getter result.
    var heat : Int = 0
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }
}

/* Inheritance */

open class Book(val title: String, val author: String) {
    private var currentPage = 1
    open fun readPage() {
        currentPage++
    }
}

class eBook(title: String, author: String, var format: String = "text") : Book(title, author) {
    private var wordsRead = 0
    override fun readPage() {
        wordsRead = wordsRead + 250
    }
}


/* Interface */

