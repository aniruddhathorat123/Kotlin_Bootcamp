class Aquarium {
    val length: Int = 100
    val width:Int = 50
    val height:Int = 20

    val volume : Int
        get() = length * width * height / 1000
}