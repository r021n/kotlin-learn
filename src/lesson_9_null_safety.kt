// Di kotling sebuah variabel tidak bisa bernilai null,
// jika ingin bernilai null kita harus mendeklarasikannya secara eksplisit menggunakan tanda ?

fun main(){

//  -----operator ? untuk null safety-----
    println("\n=================\npenggunaan operator ?\n=================\n")
    val name: String? = "Kotlin"
    val nameLength = name?.length
    println(nameLength) // output: 6

    val nullName: String? = null
    val nullNameLength = nullName?.length
    println(nullNameLength)

//  -----operator elvis "?:" untuk memberikan nilai default jika objek bernilai null-----
    println("\n=================\npenggunaan operator elvis (?:)\n=================\n")
    val nullableName: String? = null
    val defaultName = nullableName ?: "Guest"
    println(defaultName)

    val nonNullableName: String? = "Anton"
    val result = nonNullableName ?: "Dono"
    println(result)
}