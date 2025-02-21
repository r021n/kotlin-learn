fun main() {
//    =========> Lambda sederhana untuk penjumlahan
    println("\n---------Lambda dengan parameter---------")
    val pertambahan = {a: Int, b: Int -> a + b}
    val pangkatAngka = { angka: Int -> angka * angka }
    val hasitambah = pertambahan(1, 2)
    println(buildString {
        append("hasil pertambahan: ")
        append(hasitambah)
    })
    println("Hasil perpangkatan: ${pangkatAngka(10)}")

//   =========> Lambda sederhana tanpa parameter
    println("\n---------Lambda tanpa parameter---------")
    val sapaan = {println("Selamat malam kawan")}
    sapaan()
}