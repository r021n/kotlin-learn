fun main() {

//    Percabangan

    println("\n===================\nif else percabangan\n===================")

    val nilaiUjian: Int = 75

    if (nilaiUjian > 70) {
        println("selamat anda lulus")
    } else {
        println("maaf anda belum lulus")
    }

    val angka: Int = 0

    if (angka > 0) {
        println("angka positif")
    } else if (angka < 0) {
        println("angka negatif")
    } else {
        println("angka nol")
    }

//    Perulangan
    println("\n===================\nloop biasa\n===================")

    for (i in 1..5) {
        println("iterasi ke -${i}")
    }

    println("\n===================\nloop dengan step\n===================")

    for (i in 1..10 step 2){
        println("lompatan ke -${i}")
    }

    println("\n===================\nloop for menurun\n===================")

    for (i in 5 downTo 1) {
        println("Turunan ke -${i}")
    }

    println("\n===================\nloop for collection\n===================")

    val buahBuahan: List<String> = listOf("Apel", "Jeruk", "Mangga")
    for (buah in buahBuahan) {
        println("Buah ${buah}")
    }

    println("\n===================\nPerulangan berdasarkan kondisi\n===================")

    var hitungan: Int = 1
    while (hitungan <= 5) {
        println("hitungan ke -${hitungan}")
        hitungan++
    }

    var selesai: Boolean = false
    var percobaan: Int = 0
    while (!selesai) {
        percobaan++
        println("percobaan ke -${percobaan}")
        if (percobaan >= 3){
         selesai = true
        }
    }
}