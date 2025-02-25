//  Definisi class Person
class Person(var name: String, var age: Int) {
//    fungsi untuk memperkenalkan diri
fun introduceSelf() {
    println("Halo, nama saya ${name}, usia saya ${age} tahun")
}
}

class Rectangle(var width: Double, var height: Double) {
    fun calculateArea(): Double {
        return width * height
    }
}

fun main() {
//    membuat object atau instance dari class Person
    val john = Person("John doe", 29)
    val jane = Person("Jane smith", 30)

//    mengakses properti object
    println("nama John: ${john.name}")
    println("usia jane: ${jane.name}")

//    memanggil fungsi object
    john.introduceSelf()
    jane.introduceSelf()

//    membuat object rectangle
    val rectangle1 = Rectangle(20.0, 12.3)
    val rectangle2 = Rectangle(12.3, 11.4)

    println("Luas area rectangle1: ${rectangle1.calculateArea()}")
    println("Luas area rectangle2: ${rectangle2.calculateArea()}")
}