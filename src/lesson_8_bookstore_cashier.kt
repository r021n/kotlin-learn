fun main() {
    var daftarBuku: MutableList<MutableMap<String, Any>> = mutableListOf(
        mutableMapOf("Judul" to "Buku 1", "Harga" to 100000, "Stok" to 5),
        mutableMapOf("Judul" to "Buku 2", "Harga" to 200000, "Stok" to 5))
    println(daftarBuku[1]["Judul"])
}