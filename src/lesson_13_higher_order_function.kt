// fungsi yang menerima lambda sebagai parameter

fun operasiMatematika(a: Int, b:Int, operasi: (Int, Int) -> Int): Int {
    return operasi(a, b)
}

fun main() {
    println("\n-------Fungsi yang menerima labda sebagai parameter-------")
    val hasilTambah = operasiMatematika(10, 5, {a, b -> a + b})
    val hasilKali = operasiMatematika(10, 5, {a, b -> a * b})

    println("Hasil tambah $hasilTambah")
    println("Hasil kali $hasilKali")

    println("\n------------fungsi higher order bawaan kotlin (map, filter, forEach)------------")
    val angkaList = listOf(1, 2, 3, 4)
//    menggunakan map untuk menggandakan setiap angka
    val angkaGanda = angkaList.map{angka -> angka * 2}
    println("Menggandakan angka dengan map: " + angkaGanda)

//    menggunakan filter untuk menyortir angka genap
    val angkaGenap = angkaList.filter{angka -> angka % 2 == 0}
    println("Menggunakan filter untuk memfilter angka: ${angkaGenap}")

//    Menggunakan forEach untuk mengeprint setiap angka
    println("Hasil print menggunakan forEach:")
    angkaList.forEach{angka -> println("Angka: $angka")}
}