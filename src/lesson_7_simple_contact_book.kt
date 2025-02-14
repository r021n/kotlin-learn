fun main() {
    val bukuKontak: MutableMap<String, String> = mutableMapOf()

    fun tampilkanMenu() {
        println("\n---Buku Kontak Sederhana---")
        println("1. Tambah kontak")
        println("2. Lihat daftar kontak")
        println("3. Cari kontak")
        println("4. Hapus kontak")
        println("5. Keluar")
        println("Pilih menu (1-5): ")
    }

    fun tambahKontak() {
        print("Masukkan nama kontak: ")
        val nama = readLine()
        print("Masukkan nomor kontak: ")
        val nomorKontak = readLine()

        if (nama != null && nama.isNotEmpty() && nomorKontak != null && nomorKontak.isNotEmpty()){
            bukuKontak[nama] = nomorKontak
            println("Kontak $nama berhasil ditambahkan")
        } else {
            println("nama atau nomor kontak tidak boleh kosong")
        }
    }

    fun lihatKontak() {
        if (bukuKontak.isEmpty()){
            println("Buku kontak kosong")
        } else {
            println("\n---Daftar Kontak---")
            for ((nama, kontak) in bukuKontak) {
                println("$nama -> $kontak")
            }
        }
    }

    fun cariKontak() {
        print("Tuliskan nama kontak yang ingin dicari: ")
        val cariKontak = readLine()
        if (cariKontak != null && cariKontak.isNotEmpty()){
            val namaKontak = bukuKontak[cariKontak]
            if (namaKontak != null){
                println("Kontak berhasil ditemukan")
                println("$cariKontak : $namaKontak")
            } else {
                println("Kontak $cariKontak tidak ditemukan")
            }
        } else {
            println("nama tidak boleh kosong")
        }
    }

    fun hapusKontak() {
        println("Tuliskan nama kontak yang ingin dihapus: ")
        val hapusNama = readLine()
        if (hapusNama != null && hapusNama.isNotEmpty()){
            val kontakTerhapus = bukuKontak.remove(hapusNama)
            if (kontakTerhapus != null){
                println("Kontak $hapusNama berhasil dihapus")
            } else {
                println("Kontak $hapusNama tidak ada pada buku kontak")
            }
        } else {
            println("Nama kontak tidak boleh kosong")
        }
    }

    do {
        tampilkanMenu()
        val pilihan = readLine()
        when (pilihan) {
            "1" -> tambahKontak()
            "2" -> lihatKontak()
            "3" -> cariKontak()
            "4" -> hapusKontak()
            "5" -> println("Kamu keluar dari program")
            else -> println("Masukan tidak valid, harap coba lagi")
        }
    } while (pilihan != "5")
}