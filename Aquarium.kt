class Aquarium {
    var length: Int = 100
    var width:Int = 50
    var height:Int = 20

    /**
     * Override the getter and setters.
     * getter returns the volume, setter set the height based on amount of water that tank should hold.
     */
    var volume : Int
        get() = length * width * height / 1000
        set(value) { height = (value/1000) / width * length}
}