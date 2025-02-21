fun main() {
//   =========> Membuat range angka
    println("\n-------Membuat Range Angka-------")

//    range inklusif
    val angkas = 1..5
    for (angka in angkas) {
        println(angka)
    }
    println()

//    range eksklusif (sampai, tapi tidak termasuk 5)
    val angka1hg4 = 1 until 5
    for (angka in angka1hg4) {
        println(angka)
    }
    println()

//    =========> Membuat range karakter
    println("\n-------Membuat Range Karakter-------")
//    jika ingin menggunakan operator ..
    val karakterAtoC = 'A'.. 'D'
    for (karakter in karakterAtoC) {
        println(karakter)
    }
    println()

//    jika ingin menggunakan "until"
    val karakterKu = ('A'.toInt() until 'D'.toInt()).map { it.toChar() }
    for (karakter in karakterKu) {
        println(karakter)
    }

//    =========> Memeriksa keanggotaan dalam range
    println("\n-------Mengecek keanggotaan dalam range-------")
    val dalamRange = 3
    val rangeSet = 1..5
    if (dalamRange in rangeSet) {
        println("$dalamRange masuk dalam rangeSet")
    }

    val luarRange = 7
    if (luarRange !in rangeSet) {
        println("$luarRange tidak termasuk ke dalam range set")
    }
}