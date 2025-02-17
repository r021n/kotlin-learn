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
}