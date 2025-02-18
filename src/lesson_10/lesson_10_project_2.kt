package lesson_10

data class Kontak(val email: String?, val telepon: String?)
data class Pengguna(val id: Int?, val nama: String?, val kontak: Kontak?)

fun main() {
    val pengguna1 = Pengguna(1, "Rudi", Kontak("Rudi@example.com", "088880"))
    val pengguna2 = Pengguna(2, "Wawan", Kontak(null, "021020"))
    val pengguna3 = Pengguna(3, "Santi", Kontak(null, null))
    val pengguna4 = Pengguna(4, "Bimo", null)
    val daftarPengguna = listOf(pengguna1, pengguna2, pengguna3,pengguna4)

    daftarPengguna.forEach { pengguna ->
        println("\nPengguna id: ${pengguna.id}, dengan nama ${pengguna.nama}")

        val emailPengguna = pengguna.kontak?.email?: "Email tidak tersedia"
        println("Email pengguna: ${emailPengguna}")

        val panjangTelephone = pengguna.kontak?.telepon?.length?: "nomor telepone tidak tersedia"
        println("Panjang nomor telepone: ${panjangTelephone}")

        pengguna.kontak?.telepon?.let { nomorTelepon ->
            println("Nomor pengguna: ${nomorTelepon}")
        }?.also {
            println("Selesai mencetak nomor ${pengguna.nama}")
        }?: run {
            println("nomor telepone tidak tersedia")
        }
        println("----------------------------------------------")
    }

}