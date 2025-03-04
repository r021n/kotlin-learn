package lesson_20

class Buku(
    var judul: String,
    var penulis: String,
    var isbn: String,
    var genre: String,
    var tahunTerbit: Int,
) {
    fun tampilkanInfoBuku() {
        println("Judul: ${this.judul}")
        println("Penulis: ${this.penulis}")
        println("isbn: ${this.isbn}")
        println("genre: ${this.genre}")
        println("tahun terbit: ${this.tahunTerbit}")
    }
}

interface DapatDicari {
    fun cariBuku(kataKunci: String): List<Buku>
}

class Perpustakaan : DapatDicari {
    private val daftarBuku = mutableListOf<Buku>()

    fun tambahBuku(buku: Buku) {
        daftarBuku.add(buku)
        println("Buku ${buku.judul} berhasil ditambahkan ke perpustakaan")
    }

    fun hapusBuku(isbn: String) {
        val bukuYangDihapus = daftarBuku.find { it.isbn == isbn }
        if(bukuYangDihapus != null) {
            daftarBuku.remove(bukuYangDihapus)
            println("Buku ${bukuYangDihapus.judul} (ISBN: ${isbn}) berhasil dihapus dari perpustakaan")
        } else {
            println("Buku dengan ISBN $isbn tidak dapat ditemukan")
        }
    }

    override fun cariBuku(kataKunci: String): List<Buku> {
        val hasilPencarian = daftarBuku.filter {
            it.judul.contains(kataKunci, ignoreCase = true) ||
            it.genre.contains(kataKunci, ignoreCase = true) ||
            it.penulis.contains(kataKunci, ignoreCase = true)
        }

        return hasilPencarian
    }

    fun tampilkanSemuaBuku() {
        if(daftarBuku.isEmpty()) {
            println("Perpustakaan kosong")
        } else {
            println("-----Daftar Semua Buku Di Perpustakaan-----")
            daftarBuku.forEachIndexed{index, buku ->
                println("Buku ke-${index + 1}: ")
                buku.tampilkanInfoBuku()
                println("------")
            }
        }
    }
}

fun main() {
    val perpustakaanPribadi = Perpustakaan()

//    making some Buku's object
    val buku1 = Buku("Laskar Pelangi", "Andrea Hirata", "978-602-8122-04-8", "Fiksi", 2005)
    val buku2 = Buku("Bumi Manusia", "Pramoedya Ananta Toer", "978-979-97046-0-9", "Fiksi Sejarah", 1980)
    val buku3 = Buku("Sapiens: Riwayat Singkat Umat Manusia", "Yuval Noah Harari", "978-006-231625-3", "Non Fiksi", 2011)

    perpustakaanPribadi.tambahBuku(buku1)
    perpustakaanPribadi.tambahBuku(buku2)
    perpustakaanPribadi.tambahBuku(buku3)

//    show all book in library
    perpustakaanPribadi.tampilkanSemuaBuku()

//    search book based on keyword
    println("-----Hasil pencarian buku dengan kata kuncu 'Manusia'-----")
    val hasilCari = perpustakaanPribadi.cariBuku("Manusia")
    if (hasilCari.isNotEmpty()) {
        hasilCari.forEach { buku ->
            buku.tampilkanInfoBuku()
            println("-----")
        }
    } else {
        println("Tidak ditemukan buku dengan kata kunci tersebut")
    }

//    deleting book from library
    perpustakaanPribadi.hapusBuku("978-602-8122-04-8")

//    show all book after delete some book
    perpustakaanPribadi.tampilkanSemuaBuku()
}