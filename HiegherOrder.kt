
fun main() {
    higherOrder()
}

fun higherOrder() {
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println(numbers.findDivisible {
        it.rem(3)
    })
}

// higher order function.
fun List<Int>.findDivisible(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}