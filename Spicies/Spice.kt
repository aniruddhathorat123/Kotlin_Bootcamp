package Spicies

/**
 * The way of delegation...
 */
abstract sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by YellowSpiceColor {
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

    abstract fun prepareSpice()
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: Color
}

// Singleton
object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}

object RedSpiceColor : SpiceColor {
    override val color = Color.RED
}

class Curry(name : String , spicineous: String, color : SpiceColor = RedSpiceColor)
    : Spice(name, spicineous, color), Grinder {

    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
        println("Called Grind")
    }
}


fun main() {
    /*val curryObj1 = Curry()
    println("Curry coloy : ${curryObj1.color}")*/

    val spiceCabinate = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "Hot"))
    )

    for (element in spiceCabinate) println("${element.label} : ${element.color}")
}

/*
fun main (args: Array<String>) {
   delegate()
}

fun delegate() {
   val pleco = Plecostomus()
   println("Fish has has color ${pleco.color}")
   pleco.eat()
}

interface FishAction {
   fun eat()
}

interface FishColor {
   val color: String
}

object GoldColor : FishColor {
   override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
   override fun eat() {
       println(food)
   }
}

class Plecostomus (fishColor: FishColor = GoldColor):
       FishAction by PrintingFishAction("eat a lot of algae"),
       FishColor by fishColor
 */


// Data class

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
    val color = spice.color
}

// Sealed classes

sealed class Seal

class SealImpl1: Seal()
class SealImpl2: Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is SealImpl1 -> "First one"
        is SealImpl2 -> "Second one"
    }
}

//enum class
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0X0F0F00);
}