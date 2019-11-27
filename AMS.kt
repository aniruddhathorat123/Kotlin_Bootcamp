import sun.util.locale.provider.TimeZoneNameProviderImpl
import java.util.*

fun main(args: Array<String>):Unit {

    val rollDice = { sides: Int ->
        if (sides == 0) 0
        else Random().nextInt(12) + 1
    }
    println(rollDice(1))

    val doIt = { var1 : Int, var2 :Int ->
        var1 + var2
    }

    fun gamePlay(sides: Int, rollIt: (Int) -> Int):Int {
        return rollIt(sides)
    }


    //println("Your fortune is : ${getFortuneCookies()}")
    //feedTheFish()
    //println(if (args) "Good Morning" else "Good Night")
    //println(if (args[0].toInt() < 12) "Good Morning, Kotlin" else "Good Night, Kotlin")
    repeat(2) {
        println("Repeated statement")
    }
    val decoration = listOf<String>("lsit1", "item2", "item3", "item4")
    val eager = decoration.filter {it[0] == 'i'}
    val lazy = decoration.asSequence().filter { it[0] == 'i' }
}
// kotlin kone code
/*val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
println(spices.filter { it.contains("curry") }.sortedBy { it.length })
[curry, red curry, green curry]

println(spices.filter { it.startsWith('c') }.filter { it.endsWith('e') })
[cayenne]

println(spices.take(3).filter { it.startsWith('c') })
[curry, cayenne]*/

fun isTooHot(temp: Int) = temp > 30

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        isGoodMood(mood, weather) -> "go for walk"
        isSadMood(mood) -> "just watch TV"
        else -> "Stay home and read."
    }
}

fun isGoodMood(mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun isSadMood(mood: String) = mood == "sad"

fun getBirthday(listSize: Int) : Int {
    print("Enter your birthday:")
    return when (val birthday = readLine()?.toIntOrNull() ?: 1) {
        28 or 31 -> 0
        Calendar.getInstance().firstDayOfWeek -> 1
        else -> listSize/birthday
    }
}

fun getFortuneCookies() : String {
    val fortuneList = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

    return fortuneList[getBirthday(fortuneList.size)]
}

fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and fish eat $food")
}

fun randomDay() : String {
    val week = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return week.random()
}

fun dayOfWeek() {
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when (day) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "Don't Know"
        })
}

/**
 * Kotlin REPL code:
 *
 * var dirty = 20
val waterFilter : (Int) -> Int = { dirty -> dirty/2 }
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
return operation(dirty)
}

fun dirtyProcessor() {
dirty = updateDirty(dirty, waterFilter)
println(dirty)
dirty = updateDirty(dirty, ::feedFish)
println(dirty)
dirty = updateDirty(dirty, {dirty ->
dirty +50
})
println(dirty)
}

 OP:= 10 20 70
 *
 *
        */
