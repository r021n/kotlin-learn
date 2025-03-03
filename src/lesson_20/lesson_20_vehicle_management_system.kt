package lesson_20

abstract class Vehicle(var brand: String, var model: String, var year: Int) {
    abstract fun startEngine()
    abstract fun stopEngine()

    fun getVehicleInfo(): String {
        return "Merek: ${this.brand}, Model: ${this.model}, Year: ${this.model}"
    }
}

//class Car
class Car(brand: String, model: String, year: Int, var numberOfDoors: Int) : Vehicle(brand, model, year) {
    override fun startEngine() {
        println("Mobil ${this.brand} ${this.model}: Mesin mobil dinyalakan")
    }

    override fun stopEngine() {
        println("Mobil ${this.brand} ${this.model}: Mesin mobil dimatikan")
    }

    fun honk() {
        println("Mobil ${this.brand} ${this.model}: Klakson berbunyi! Beep beep!")
    }
}

class Motorcycle(brand: String, model: String, year: Int, var engineType: String): Vehicle(brand, model, year) {
    override fun startEngine() {
        println("Motor ${this.brand} ${this.model}: Mesin motor dinyalakan")
    }

    override fun stopEngine() {
        println("Motor ${this.brand} ${this.model}: Mesin motor dimatikan")
    }

    fun wheelie() {
        println("Motor ${this.brand} ${this.model} melakukan wheelie!")
    }
}

class Truck(brand: String, model: String, year: Int, var cargoCapacity: Double): Vehicle(brand, model, year) {
    override fun startEngine() {
        println("Truck ${this.brand} ${this.model} mesin struck dinyalakan")
    }

    override fun stopEngine() {
        println("Truck ${this.brand} ${this.model} mesin truck dimatikan")
    }

    fun loadCargo() {
        println("Truck ${this.brand} ${this.model} muatan sedang dimuat")
    }
}

fun main() {
    val car1 = Car("Toyota", "Avanza", 2020, 4)
    val motorcycle1 = Motorcycle("Honda", "vario", 2022, "4-tak")
    val truck1 = Truck("Hino", "Ranger", 2018, 18.0)
}