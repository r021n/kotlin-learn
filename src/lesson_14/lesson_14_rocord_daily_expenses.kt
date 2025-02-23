package lesson_14

data class Expense(val id: Int,
                   val amount: Double,
                   val category: String,
                   val description: String)

fun main() {
    val expenses = mutableListOf<Expense>()
    val categories = setOf("Makanan", "Transportasi", "Hiburan", "Lainnya")
    var nextId = 1
    val budget = 500000.0

    while(true) {
        println("\n-----------Pelacak Pengeluaran Harian-----------")
        println("Pilihan:\n[1]\tTambah Pengeluaran\n[2]\tLihat Total Per kategori\n[3]\tCek Anggaran\n[4]\tKeluar")
        val choice = readLine()?.toIntOrNull()

        when(choice) {
            1 -> addExpense(expenses, categories, nextId).also{nextId++}
            2 -> showExpensesByCategory(expenses, categories)
            3 -> checkBudget(expenses, budget)
            4 -> {
                println("Terimakasih sudha menggunakan aplikasi pelacak pengeluaran ini")
                break
            }
            else -> println("Pilihan tidak valid, masukkan 1-4")
        }
    }
}

fun addExpense(expenses: MutableList<Expense>, categories: Set<String>, id:Int) {
    println("Masukkan jumlah pengeluaran (Rp): ")
    val amount = readLine()?.toDoubleOrNull()?: return println("Jumlah tidak valid")

    println("Pilih kategori ${categories.joinToString()}}")
    val category = readLine() ?: "Lainnya"
    val validCategory = if (category in categories) category else "Lainnya"

    println("Masukkan deskripsi (opsional): ")
    val description = readLine().let { it ?: "Tanpa deskripsi" }

    expenses.add(Expense(id, amount, validCategory, description))
    println("Pengeluaran ditambahkan: Rp$amount untuk $validCategory - $description")
}

fun showExpensesByCategory(expenses: List<Expense>, categories: Set<String>) {
    if (expenses.isEmpty()) {
        println("belum ada pengeluaran yang dicatat")
        return
    }

    println("\nPengeluaran per kategori: ")
    val groupedExpenses = expenses.groupBy { it.category }
    categories.forEach{category ->
        val total = groupedExpenses[category]?.sumOf { it.amount ?: 0.0 }
        println("$category: Rp$total")
    }
}

fun checkBudget(expenses: List<Expense>, budget: Double) {
    val totalSpent = expenses.sumOf { it.amount }

    if(totalSpent > budget) {
        val overBudget = totalSpent - budget
        println("Peringatan, anda melebihi budget sebesar Rp$overBudget")
    } else {
        val remaining = budget - totalSpent
        println("anggaran tersiswa Rp$remaining dari Rp$budget")
    }

//  contoh menghitung range untuk pengeluaran kecil
    val smalExpenses = expenses.filter { it.amount in 0.0..50000.0 }
    println("Pengeluaran kecil (<Rp50.000) ${smalExpenses.size} transaksi")
}