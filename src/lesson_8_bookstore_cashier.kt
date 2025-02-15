fun main() {
    var daftarBuku: MutableList<MutableMap<String, Any>> = mutableListOf()

    fun tampilkanMenu() {
        println("\n---Menu Pilihan---")
        println("1. Tampilkan daftar buku")
        println("2. Tambah buku")
        println("3. Hapus buku")
        println("4. Edit buku")
        println("5. Lihat sisa buku")
        println("6. Riwayat penjualan buku")
        println("7. Jual buku")
        println("8. Keluar aplikasi")
        print("Masukkan pilihanmu: ")
    }

    fun tambahBuku() {
        print("Masukan nama buku: ")
        val namaBuku = readLine()
        print("Masukan harga buku: ")
        val hargaBuku = readLine()
        print("Masukan jumlah buku: ")
        val jumlahBuku = readLine()

        if (namaBuku != null && hargaBuku != null && jumlahBuku != null){
            daftarBuku.add(mutableMapOf(
                "Judul" to namaBuku,
                "Harga" to hargaBuku,
                "Stok" to jumlahBuku))
            println("Berhasil menambahkan buku $namaBuku")
        } else {
            println("Input tidak valid")
        }
    }

    fun tampilkanBuku() {
        if (daftarBuku.isEmpty()){
            println("Belum ada buku yang ditambahkan")
        } else {
            for (buku in daftarBuku){
                println("${buku["Judul"]} \t ${buku["Harga"]} \t ${buku["Stok"]}")
            }
        }
    }

    fun cariIndexBuku(daftarBuku: List<Map<String, Any>>, judulBuku: String): Int {
        return daftarBuku.indexOfFirst { it["Judul"] == judulBuku }
    }

    fun hapusBuku() {
        print("Masukkan nama buku yang ingin dihapus: ")
        val namaBuku = readLine()
        if (namaBuku != null && namaBuku.isNotEmpty()){
            val indexBuku = cariIndexBuku(daftarBuku, namaBuku)
            if (indexBuku != -1) {
                daftarBuku.removeAt(indexBuku)
                println("Buku $namaBuku berhasil dihapus")
            } else {
                println("Tidak terdapat buku dengan judul $namaBuku")
            }
        } else {
            println("Input tidak boleh kosong")
        }
    }

    fun editBuku() {
        if (daftarBuku.isEmpty()) {
            println("tidak terdapat buku yang dapat diedit")
        } else {
            print("Masukkan nama buku yang ingin diedit: ")
            val namaBuku = readLine()
            if (namaBuku != null && namaBuku.isNotEmpty()){
                val indexBuku = cariIndexBuku(daftarBuku, namaBuku)
                if (indexBuku != -1){
                    val buku = daftarBuku[indexBuku]

                    print("Masukan judul buku yang baru (kosongkan jika tidak ingin mengganti): ")
                    val judulBaru = readLine()
                    print("Masukan harga buku yang baru (kosongkan jika tidak ingin mengganti): ")
                    val hargaBaru = readLine()
                    print("Masukan stok buku yang baru (kosongkan jika tidak ingin mengganti): ")
                    val stokBaru = readLine()

                    if (!judulBaru.isNullOrBlank()) {
                        buku["Judul"] = judulBaru
                    }

                    if (!hargaBaru.isNullOrBlank()) {
                        try {
                            val harga = hargaBaru.toInt()
                            buku["Harga"] = harga
                        } catch (e: NumberFormatException) {
                            println("input harus berupa angka")
                        }
                    }

                    if (!stokBaru.isNullOrBlank()) {
                        try {
                            val stok = stokBaru.toInt()
                            buku["Stok"] = stok
                        } catch (e: NumberFormatException) {
                            println("input harus berupa angka")
                        }
                    }

                    println("Sukses mengganti mengedit buku")

                } else {
                    println("Tidak terdapat buku dengan judul $namaBuku")
                }
            } else {
                println("Input tidak boleh kosong")
            }
        }
    }

    do {
        tampilkanMenu()
        val userInput= readLine()
        when (userInput) {
            "1" -> tampilkanBuku()
            "2" -> tambahBuku()
            "3" -> hapusBuku()
            "4" -> editBuku()
            "5" -> println("Keluar dari menu")
            else -> println("input tidak valid")
        }
    } while (userInput != "5")
}