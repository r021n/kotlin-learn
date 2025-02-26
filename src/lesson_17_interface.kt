interface Drivable {
    fun startEngine()
    fun stopEngine()
}

interface Flyable {
    fun takeOff()
    fun land()
}

//=========================================================================

class Car(var model: String) : Drivable {
    override fun startEngine() {
        println("Mobil ${this.model} mesin dinyalakan")
    }

    override fun stopEngine() {
        println("Mobil ${this.model} mesin dimatikan")
    }

    fun drive() {
        println("Mobil ${this.model} sedang dikendarai")
    }
}

class Motorcycle(var brand: String) : Drivable {
    override fun startEngine() {
        println("Motor ${this.brand} mesin dinyalakan")
    }

    override fun stopEngine() {
        println("Motor ${this.brand} mesin dimatikan")
    }

    fun wheelie() {
        println("Motor ${this.brand} melakukan wheelie")
    }
}

//=========================================================================

class Plane(var model: String) : Flyable {
    override fun takeOff() {
        println("Pesawat ${this.model} lepas landas")
    }

    override fun land() {
        println("Pesawat ${this.model} mendarat")
    }
}

class Bird(var species: String) : Flyable {
    override fun takeOff() {
        println("Burung ${this.species} terbang")
    }

    override fun land() {
        println("Burung ${this.species} hinggap")
    }
}

//=========================================================================
fun main() {
    val car = Car("Sedan")
    val motorcycle = Motorcycle("SportBike")

    car.startEngine()
    car.drive()
    car.stopEngine()

    motorcycle.startEngine()
    motorcycle.wheelie()
    motorcycle.stopEngine()

    val vehicles: List<Drivable> = listOf(car, motorcycle)
    for (vehicle in vehicles) {
        vehicle.startEngine()
        vehicle.stopEngine()
        println("-----------------")
    }

    println("\n=======================================================")
    val plane = Plane("Boeing")
    val manuk = Bird("Greja")

    plane.takeOff()
    plane.land()

    manuk.takeOff()
    manuk.land()

    val flyObjects: List<Flyable> = listOf(plane, manuk)
    for (fly in flyObjects) {
        fly.takeOff()
        fly.land()
        println("------------------")
    }
}