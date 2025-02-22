package lesson_14

data class Expense(val id: Int,
                   val amount: Double,
                   val category: String,
                   val description: String)

fun main() {
    val expenses = mutableListOf<Expense>()
    val categories = setOf("Makanan", "Transportasi", "Hiburan", "Lainnya")
    val nextId = 1
    val budget = 500000.0

    while(true) {
        println("\n-----------Pelacak Pengeluaran Harian-----------")
        println("Pilihan:\n[1]\tTambah Pengeluaran\n[2]\tLihat Total Per kategori\n[3]\tCek Anggaran\n[4]\tKeluar")
        val choice = readLine()?.toIntOrNull()
    }
}