fun main(){
    val daftarTugas: MutableList<String> = mutableListOf()

    fun tampilkanMenu() {
        println("\n--- Manajemen Daftar Tugas ---\n")
        println("1. Tambah tugas")
        println("2. Lihat daftar tugas")
        println("3. Tandai tugas selesai")
        println("4. Hapus tugas")
        println("5. Keluar")
        print("Pilih menu (1-5): ")
    }

    fun tambahTugas() {
        print("Masukan tugas baru: ")
        val tugasBaru = readLine()
        if (tugasBaru != null && tugasBaru.isNotEmpty()) {
            daftarTugas.add(tugasBaru)
            println("Tugas baru berhasil ditambahkan")
        } else {
            println("Tugas tidak boleh kosong")
        }
    }

    fun lihatDaftarTugas() {
        if (daftarTugas.isEmpty()){
            println("Tidak ada daftar tugas")
        } else {
            for ((index, tugas) in daftarTugas.withIndex()){
                println("${index + 1}. $tugas")
            }
        }
    }

    fun tandaiTugasSelesai() {
        lihatDaftarTugas()
        if (!daftarTugas.isEmpty()) {
            print("Pilih nomor tugas yang sudah selesai")
            val nomorTugasInput = readLine()
            if (nomorTugasInput != null){
                val nomorTugas = nomorTugasInput.toIntOrNull()
                if (nomorTugas != null && nomorTugas >= 1 && nomorTugas <= daftarTugas.size){
                    val indexTugas = nomorTugas - 1
                    val tugasSelesai = daftarTugas.removeAt(indexTugas)
                    println("Tugas $tugasSelesai ditandai selesai dan dihapus dari daftar")
                }
            } else {
                println("Nomor tugas tidak valid")
            }
        }
    }

    fun hapusTugas() {
        lihatDaftarTugas()
        if (!daftarTugas.isEmpty()){
            println("Piliha nomor tugas yang ingin dihapus")
            val nomorInput = readLine()
            if (nomorInput != null) {
                val nomorTugas = nomorInput.toIntOrNull()
                if (nomorTugas != null && nomorTugas >= 1 && nomorTugas <= daftarTugas.size){
                    val indexTugas = nomorTugas - 1
                    val tugasTerhapus = daftarTugas.removeAt(indexTugas)
                    println("Tugas $tugasTerhapus telah dihapus dari daftar")
                }
            } else {
                println("Nomor tugas tidak valid")
            }
        }
    }

    do {
        tampilkanMenu()
        val pilihanUser = readLine()
        when (pilihanUser) {
            "1" -> tambahTugas()
            "2" -> lihatDaftarTugas()
            "3" -> tandaiTugasSelesai()
            "4" -> hapusTugas()
            "5" -> println("Keluas dari program")
            else -> println("pilihan tidak valid, silahkan coba lagi")
        }
    } while (pilihanUser != "5")
}