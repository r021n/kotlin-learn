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

//  -----operator not null assertion "!!" untuk memaksa menganggap sebuah variabel nullable tidak bernilai null.
//  jika ternyata variable tersebut berniali null, maka akan megembalikan NullPointerException-----
    println("\n=================\npenggunaan not null assertion (!!)\n=================\n")
    val nullableName2: String? = null

    try {
        val lengthNull = nullableName2!!.length
        println(lengthNull)
    } catch (e: NullPointerException) {
        println("Terjadi NullPointerException")
    }
}