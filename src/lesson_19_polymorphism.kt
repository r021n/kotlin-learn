//Polimorphysm memungkinkan objek dari class yang berbeda merespon suatu fungsi atau method yang sama sesuai dengan tipenya

//polimorphysm terdiri dari static polimophysm/function overloading dan dynamic polimorphysm/function overriding
//inheritence dan interface merupakan contoh penerapan dari dynamic polimorphysm/function overriding

//dan berikut adalah contoh penerapan dari static polimorphysm/function overloading
class Calculator{
    fun add(a: Int, b:Int): Int {
        println("Menambahkan dua integer")
        return a + b
    }

    fun add(a: Double, b: Double): Double {
        println("Menambahkan dua double")
        return a + b
    }

    fun add(a: Int, b: Int, c: Int): Int {
        println("Menambahkan tida integer")
        return a + b + c
    }
}

//==============================================================================
class ShapeCalculator {
    fun calculateShapeArea(circle: Circle): Double {
        println("Menghitung luas lingkaran")
        return circle.calculateArea()
    }

    fun calculateShapeArea(square: Square): Double {
        println("menghitung luas persegi")
        return square.calculateArea()
    }

    fun calculateShapeArea(rectangle: Rectangle): Double {
        println("Menghitung luas persegi panjang")
        return rectangle.calculateArea()
    }
}

fun main() {
    val calculator = Calculator()

    calculator.add(2, 3)
    calculator.add(2.1, 3.3)
    calculator.add(4, 3, 1)
    println("\n===================================")

    val circle = Circle("Lingkaran", 4.0)
    val square = Square("Persegi", 6.0)
    val rectangle = Rectangle(5.0, 10.0)

    val calculator2 = ShapeCalculator()

    println("Luas Lingkaran: ${calculator2.calculateShapeArea(circle)}")
    println("Luas Persegi: ${calculator2.calculateShapeArea(square)}")
    println("Luas Persegi Panjang: ${calculator2.calculateShapeArea(rectangle)}")
}