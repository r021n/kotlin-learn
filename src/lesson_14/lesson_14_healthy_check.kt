package lesson_14

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class DataKesehatan(
    val tanggal:LocalDate,
    val beratBadan: Double?,
    val tekananDarahSistolik: Int?,
    val tekananDarahDiastolik: Int?,
    val detakJantung: Int?,
    val kualitasTidur: Int?
)

class AplikasiKesehatan{
    private val dataKesehatanHarian = mutableListOf<DataKesehatan>()
    private val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    fun catatDataKesehatan() {
        println("------------------------")
        println("Catat data kesehatan harian")
        println("------------------------")

        val tanggal =LocalDate.now()

        print("Berat badan (Kg) (Kosongkan jika tidak ingin mencatat): ")
        val beratBadan = readLine()?.toDoubleOrNull()

        print("Tekanan darah sistolik (atas) (Kosongkan jika tidak ingin mencatat): ")
        val tekananDarahSistolik = readLine()?.toIntOrNull()

        print("Tekanan dara diastolik (bawah) (kosongkan jika tidak ingin mencatat): ")
        val tekananDarahDiastolik = readLine()?.toIntOrNull()

        print("Detak jantung (bpm) (kosongkan jika tidak ingin mencatat): ")
        val detakJantung = readLine()?.toIntOrNull()

        print("Kualitas tidur (skor 1 - 5, kosongkan jika tidak inging mencatat): ")
        val kualitasTidur = readLine()?.toIntOrNull()

        val dataBaru = DataKesehatan(tanggal, beratBadan, tekananDarahSistolik, tekananDarahDiastolik, detakJantung, kualitasTidur)
        dataKesehatanHarian.add(dataBaru)
        println("Data kesehatan berhasil dicatat untuk tanggal ${tanggal.format(formatter)}.")
    }

    fun tampilkanDataKesehatan() {
        if (dataKesehatanHarian.isEmpty()) {
            println("Belum ada data kesehatan yang tercatat")
            return
        }

        println("----------------------------")
        println("Data kesehatan yang tercatat")
        println("----------------------------")

        dataKesehatanHarian.forEach{ data ->
            println("Tanggal: ${data.tanggal.format(formatter)}")
            data.beratBadan?.let { println("Berat badan: $it kg") }
            data.tekananDarahSistolik?.let { sistolik ->
                data.tekananDarahDiastolik?.let {diastolik ->
                    println("Tekanan darah: $sistolik/$diastolik mmHg ")
                }
            }
            data.detakJantung?.let { println("Detak jantung $it bpm") }
            data.kualitasTidur?.let { println("Kualitas tidur skala $it ") }
            println("----------------------------")
        }
    }

    fun analisisKesehatan() {
        if (dataKesehatanHarian.isEmpty()) {
            println("Belum ada data kesehatan untuk dianalisis")
            return
        }

        println("----------------------------")
        println("Analisis data kesehatan")
        println("----------------------------")

        hitungaRataRataBeratBadan()
        hitungRataRataTekananDarah()
        hitungRataRataDetakJantung()
        hitungRataRataKualitasTidur()
    }

    private fun hitungaRataRataBeratBadan() {
        val beratBadanValues = dataKesehatanHarian.mapNotNull { it.beratBadan }
        if (beratBadanValues.isNotEmpty()) {
            val rataRataBeratBadan = beratBadanValues.average()
            println("Rata-rata berat badan: ${String.format("%.2f", rataRataBeratBadan)} Kg")
        } else {
            println("Data berat badan belum tersedia untuk dianalisis")
        }
    }

    private fun hitungRataRataTekananDarah() {
        val sistolikValues = dataKesehatanHarian.mapNotNull { it.tekananDarahSistolik }
        val diastolikValues = dataKesehatanHarian.mapNotNull { it.tekananDarahDiastolik }

        if(sistolikValues.isNotEmpty() && diastolikValues.isNotEmpty()) {
            val rataRataSistolik = sistolikValues.average()
            val rataRataDiastolik = diastolikValues.average()
            println("Rata rata tekanan darah: ${String.format("%.0f", rataRataSistolik)}/${String.format("%.0f", rataRataDiastolik)} mmHg")
        } else {
            println("Data tekanan darah belum tersedia untuk dianalisis")
        }
    }

    private fun hitungRataRataDetakJantung() {
        val detakJantungValues = dataKesehatanHarian.mapNotNull { it.detakJantung }
        if (detakJantungValues.isNotEmpty()) {
            val rataRataDetakJantung = detakJantungValues.average()
            println("Rata rata detak jantung ${String.format("%.0f", rataRataDetakJantung)} bpm")
        } else {
            println("Detak jantung belum tersedia untuk dianalisis")
        }
    }

    private fun hitungRataRataKualitasTidur() {
        val kualitasValues = dataKesehatanHarian.mapNotNull { it.kualitasTidur }
        if (kualitasValues.isNotEmpty()) {
            val kualitasTidur = kualitasValues.average()
            println("Rata rata kualitas tidur: ${String.format("%.2f", kualitasTidur)} (skala 1 - 5)")
        } else {
            println("Data kualitas tidur belum tersedia untuk dianalisis")
        }
    }

    fun tampilkanMenu() {
        while(true) {
            println("\n-------------Menu Aplikasi Kesehatan-------------")
            println("1. Catat data kesehatan")
            println("2. Tampilkan data kesehatan")
            println("3. Analisis data kesehatan")
            println("4. Keluar")
            print("Pilih menu (1 - 4): ")

            when(readLine()?.toIntOrNull()) {
                1 -> catatDataKesehatan()
                2 -> tampilkanDataKesehatan()
                3 -> analisisKesehatan()
                4 -> {
                    println("Kamu keluar dari aplikasi, selamat tingggal")
                    return
                }
                else -> println("input yang dimasukkan tidak valid, silahkan coba lagi")
            }
        }
    }
}

fun main() {
    val aplikasi = AplikasiKesehatan()
    aplikasi.tampilkanMenu()
}