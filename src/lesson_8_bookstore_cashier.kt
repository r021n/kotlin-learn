fun main() {
    var daftarBuku: MutableList<MutableMap<String, Any>> = mutableListOf()

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

    tambahBuku()
    for (buku in daftarBuku) {
        print("${buku["Judul"]} | ${buku["Harga"]} | ${buku["Stok"]}")
    }
}