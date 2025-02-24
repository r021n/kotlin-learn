package lesson_14

data class WaterEntry(val amount: Int, val time: String)

fun main() {
    val waterLog = mutableListOf<WaterEntry>()
    var dailyTarget: Int? = null

    while(true) {
        println("\n---------pelacak kebiasaan minum air---------")
        println("Pilih operasi\n[1]\tSet target harian\n[2]\tTambah konsumsi air\n[3]\tLihat progress\n[4]\tKeluar")
        print("Masukkan pilihanmu: ")
        val choice = readLine()?.toIntOrNull()

        when(choice) {
            1 -> dailyTarget = setDailyTarget()
            2 -> addWaterConsumption(waterLog)
            3 -> showProgress(waterLog, dailyTarget)
            4 -> {
                println("Terimakasih sudah menggunakan aplikasi ini")
                break
            }
            else -> println("Inputan tidak valid, silahkan masukkan (1 - 4)")
        }
    }
}

fun setDailyTarget(): Int {
    println("Masukkan target harian air minul (ml), rekomendasi 2000-3000 ml: ")
    val target = readLine()?.toIntOrNull() ?: return 2000
    return if (target in 1000..5000) target else {
        println("Target diluar rentang wajar, di set ke 2000 ml")
        2000
    }
}

fun addWaterConsumption(waterLog: MutableList<WaterEntry>) {
    println("Masukkan jumlah air yang diminum: ")
    val amount = readLine()?.toIntOrNull() ?: return println("Jumlah tidak valid")

    println("Masukkan waktu (contoh: 08.30)")
    val time = readLine() ?: return println("Waktu tidak boleh kosong")

    waterLog.add(WaterEntry(amount, time))
    println("$amount ml air ditambahkan pada pukul $time")
}

fun showProgress(waterLog: List<WaterEntry>, dailyTarget: Int?) {
    if (dailyTarget == null) {
        println("Silahkan set target harian lebih dahulu")
        return
    }
    if (waterLog.isEmpty()) {
        println("Belum ada konsumsi air yang dicatat")
        return
    }

    val totalConsumed = waterLog.sumOf { it.amount }
    val percentage = (totalConsumed.toDouble() / dailyTarget * 100).toInt()

    println("\nProgress harian")
    println("Target: $dailyTarget")
    println("Total dikonsumsi: $totalConsumed")
    println("Persentase tercapai: $percentage")

    println("Riwayat konsumsi air")
    waterLog.forEach { entry ->
        println("${entry.amount}ml pada pukul ${entry.time}")
    }

    val message = when{
        percentage >= 100 -> "selamat target harian tercapai"
        percentage >= 50 -> "Bagus, kamu sudah separuh jalan"
        else -> "Semangat, ayo tambah lagi konsumsi airmu"
    }

    println(message)
}