fun main() {
//    List => terurut dan boleh terdapat duplikasi
    println("\n===============\nimmutable list\n===============")

    var daftarNama: List<String> = listOf("Budi", "Siti", "Andi")
    println("Daftar Nama ${daftarNama}")
    println("Nama pertama ${daftarNama[0]}")
    println("Jumlah Nama " + daftarNama.size)

//    display setiap nama menggunakan for
    for (nama in daftarNama) {
        println("Nama: " + nama)
    }

    println("\n===============\nmutable list\n===============")
    val daftarAngka: MutableList<Int> = mutableListOf(10, 20, 30)
    println("Daftar angka sebelum diubah" + daftarAngka)

    daftarAngka.add(40) // menambahkan angka baru pada list
    daftarAngka[1] = 25 // mengganti sebuah index menjadi value baru

    println("Daftar angka setelah diubah" + daftarAngka)
}
