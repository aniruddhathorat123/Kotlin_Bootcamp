package Generic

open class BaseBuildingMaterial(var numberNeeded: Int = 1)

class Wood(): BaseBuildingMaterial(4) {
}

class Brick(): BaseBuildingMaterial(8) {
}

// Generic class for BaseBuildingMaterial
class Buildings<T: BaseBuildingMaterial>(matrial: T) {
    val baseMaterialsNeeded = 100
    val actualMaterialNeeded = baseMaterialsNeeded - matrial.numberNeeded

    fun build() {
        println("Total material need:$actualMaterialNeeded")
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Buildings<T>) {
    if (building.actualMaterialNeeded < 500) {
        println("Small Building")
    } else {
        println("Large Building")
    }
}

fun main() {
    val firstBuilding = Buildings(Wood())
    val secondBuildings : Buildings<Brick> = Buildings(Brick())

    firstBuilding.build()
    secondBuildings.build()
}