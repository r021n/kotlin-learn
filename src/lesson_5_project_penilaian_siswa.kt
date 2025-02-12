fun main() {
//    Map untuk menyimpan data siswa
    val nilaiSiswa: MutableMap<String, Int> = mutableMapOf()

//    fungsi untuk menambahkan siswa dan nilainya
    fun tambahSiswa(nama: String, nilai: Int){
        nilaiSiswa[nama] = nilai
    }

//    fungsi untuk menghitung rata-rata nilai siswa
    fun hitungRataRata(): Double {
        if (nilaiSiswa.isEmpty()){
            return 0.0
        }

        var totalNilai = 0
        for (nilai in nilaiSiswa.values) {
            totalNilai += nilai
        }

        return totalNilai.toDouble() / nilaiSiswa.size
    }

    fun penentuKelulusan(nilai: Double): String {
        return if (nilai >= 70) {
            "Lulus"
        } else {
            "Tidak lulus"
        }
    }

//    manambahkan data siswa dan nilainya
    tambahSiswa("Andi", 80)
    tambahSiswa("Budi", 65)
    tambahSiswa("Siti", 92)

//    hitung rata rata kelas
    val rataRataKelas = hitungRataRata()

//    tentukan status kelulusan siswa
    val statusKelas = penentuKelulusan(rataRataKelas)

//    menampilkan informasi
    println("---Daftar Nilai Siswa---")
    for ((nama, nilai) in nilaiSiswa){
        println("$nama : $nilai")
    }
    println("-----------------------")
    println("Rata rata nilai kelas: $rataRataKelas")
    println("Status kelulusan kelas: $statusKelas")

//    penggunaan loop untuk menampilkan siswa yang lulus KKM
    println("-------Daftar siswa yang lulus-------")
    for ((nama, nilai) in nilaiSiswa){
        if(nilai >= 70){
            println(nama)
        }
    }
}
