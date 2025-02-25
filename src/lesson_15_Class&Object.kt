//  Definisi class Person
class Person(var name: String, var age: Int) {
//    fungsi untuk memperkenalkan diri
fun introduceSelf() {
    println("Halo, nama saya ${name}, usia saya ${age} tahun")
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
}