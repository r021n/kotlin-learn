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
    println(nullNameLength) // output: null

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

//  -----fungsi "let" digunakan untuk mengeksekusi blok kode jika sebuah objek tidak bernilai null-----
    println("\n=================\npenggunaan fungsi let\n=================\n")
    val nullableName1: String? = "Kotlin"
    nullableName1?.let {
        println("Nama $it tidak null")
        println("Panjang $it adalah ${it.length}")
    }

    val nullName1: String? = null
    nullName1?.let {
        println("Ini tidak akan dieksekusi karena bernilai null")
    }

//  -----fungsi "also" mirip seperti "let" tetapi hanya berfungsi untuk
//  mengeksekusi fungsi sampingan dan tidak berefek pada objek utama-----
    println("\n=================\npenggunaan fungsi also\n=================\n")
    val nullableValue: String? = "Kotlin"

    val result2 = nullableValue?.also {
        println("Nama saat ini $it")
        println("Panjang nama saat ini ${it.length}")
    }

    println(result2)
}