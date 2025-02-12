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

//    Set => tidak terurut dan tidak boleh terulang
    println("\n===============\nimmutable set\n===============")
    val angkaUnik: Set<Int> = setOf(1, 2, 3, 4, 5, 6, 7)
    println("Angka unik ${angkaUnik}")
    println("Angka unik ${angkaUnik.size}")

    println("\n===============\nmutable set\n===============")
    val hurufSet: MutableSet<Char> = mutableSetOf('A', 'B', 'C')
    hurufSet.add('D')
    hurufSet.add('B')

    println("Huruf set setelah ada penambahan " + hurufSet)

//    Map => Koleksi pasangan kunci-nilai
    println("\n===============\nimmutable map\n===============")
    val nilaiSiswa: Map<String, Int> = mapOf(
        "Budi" to 85,
        "Sinti" to 90,
        "Andi" to 78,
    )
    println("Nilai para siswa adalah: ${nilaiSiswa}")
    println("Nilai Budi: " + nilaiSiswa["Budi"])
    println("Nilai Joko: " + nilaiSiswa["Joko"])

    println("\n===============\niterasi melalui map\n===============")
    for ((nama, nilai) in nilaiSiswa) {
        println("$nama mendapat nilai $nilai")
    }

    println("\n===============\nmutable map\n===============")
    val stokBarang: MutableMap<String, Int> = mutableMapOf(
        "Buku" to 200,
        "Pensil" to 100,
    )

    stokBarang["Pulpen"] = 200
    stokBarang["Buku"] = 150

    println("Stok barang setelah diubah $stokBarang")
}
