abstract class Shape(var name: String) {
    abstract fun calculateArea(): Double

    fun getDescription(): String {
        return("Ini adalah bentuk ${this.name}")
    }
}

abstract class Vehicle(var brand: String) {
    abstract fun start()
    abstract fun stop()

    fun getBrandName(): String {
        return "nama kendaraan ini adalah ${this.brand}"
    }
}
//===========================================================

class Circle(name: String, var radius: Double) : Shape(name) {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Square(name: String, var side: Double) : Shape(name) {
    override fun calculateArea(): Double {
        return side * side
    }
}

//===========================================================

class CarNew(brand: String) : Vehicle(brand) {
    override fun start() {
        println("Mobil ${this.brand} dimulai.....")
    }
    override fun stop() {
        println("Mobil ${this.brand} berhenti.....")
    }
}

class MotorNew(brand: String) : Vehicle(brand) {
    override fun start() {
        println("Motor ${this.brand} dinyalakan.....")
    }

    override fun stop() {
        println("Motor ${this.brand} dimatikan.....")
    }
}

//===========================================================

fun main() {
//    val shape = Shape("Bentuk") ===> Error! tidak bisa membuat object dari abstract class
    val circle = Circle("Lingkaran", 5.0)
    val square = Square("Persegi", 7.0)

    println(circle.getDescription())
    println("Luas lingkaran: ${String.format("%.2f", circle.calculateArea())}")

    println(square.getDescription())
    println("Luas persegi: ${String.format("%.2f", square.calculateArea())}\n")

    val shapes: List<Shape> = listOf(circle, square)
    for (shape in shapes) {
        println(shape.getDescription())
        println("Luas area: ${String.format("%.2f", shape.calculateArea())}")
        println("--------")
    }

//    ==========================================================================
    println("================================")
    val car = CarNew("Toyota")
    val motor = MotorNew("Honda")

    car.start()
    car.stop()

    motor.start()
    motor.stop()

    val vehicles: List<Vehicle> = listOf(car, motor)
    for (vehicle in vehicles) {
        println(vehicle.getBrandName())
        vehicle.start()
        vehicle.stop()
        println("----------")
    }
}