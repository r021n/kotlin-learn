package lesson_10

data class Book(
    val id: Int,
    var title: String?,
    var author: String?,
    var year: Int?
)

class BookManager {
    private val books = mutableListOf<Book>()

//    function for adding new book
fun addBook(book: Book) {
    book.also {
        books.add(it)
        println("Buku berhasil ditambahkan ${book.title ?: "Judul tidak diketahui"}")
    }
}

//    function to see all books
fun viewBooks() {
    if(books.isEmpty()) {
      println("Tidak ada buku yang tersedia")
      return
    }

    println("Daftar Buku")
    books.forEach{book ->
        book.let {
            println("ID: ${it.id}")
            println("Mame: ${it.title ?: "judul buku tidak diketahui"}")
            println("Author: ${it.author ?: "penulis buku tidak diketahui"}")
            println("Year: ${it.year ?: "tahun terbit buku tidak diketahui"}")
        }
    }
}

//    function to update book by id
fun updateBook(id: Int, newTitle: String?, newAuthor: String?, newYear: Int?) {
    val book = books.find { it.id == id }
    book?.let {
        if (!newTitle.isNullOrEmpty()) {
            it.title = newTitle
        }

        if (!newAuthor.isNullOrEmpty()) {
            it.author = newAuthor
        }

        newYear?.let {year -> it.year = year}
        println("Data buku ${it.title} berhasil diperbarui")
    } ?: println("Buku dengan id ${id} tidak dapat ditemukan")
}

//    function to delete book
fun deleteBook(id: Int) {
    val book = books.find { it.id == id }
    book?.let {
        books.remove(it)
        println("Buku dengan id $id berhasil dihapus")
    } ?: println("Buku dengan id $id tidak dapat ditemukan")
}
}

fun main() {
    val bookManager = BookManager()

    while(true) {
        println("\n-----Aplikasi manajemen buku-----")
        println("1. Tambah buku")
        println("2. Lihat semua buku")
        println("3. Perbarui buku")
        println("4. Hapus buku")
        println("5. Keluar")
        print("Masukkan pilihanmu: ")

        when(readLine()?.toInt()) {
            1 -> {
                print("Masukkan ID buku: ")
                val id = readLine()?.toIntOrNull() ?: continue
                print("Masukkan judul buku: ")
                val title = readLine()
                print("Masukkan penulis buku: ")
                val author = readLine()
                print("Masukkan tahun terbit buku: ")
                val year = readLine()?.toIntOrNull()

                val newBook = Book(id, title, author, year)
                bookManager.addBook(newBook)
            }
            2 -> bookManager.viewBooks()
            3 -> {
             print("Masukkan id buku yang ingin diperbarui: ")
             val id = readLine()?.toIntOrNull() ?: continue
             print("Masukkan judul buku yang baru: ")
             val newTitle = readLine()
             print("Masukkan penulis buku yang baru: ")
             val newAuthor = readLine()
             print("Masukkan tahun terbit yang baru: ")
             val newYear = readLine()?.toIntOrNull()

             bookManager.updateBook(id, newTitle, newAuthor, newYear)
            }
            4 -> {
                print("Masukkan id buku yang ingin dihapus")
                val id = readLine()?.toIntOrNull() ?: continue
                bookManager.deleteBook(id)
            }
            5 -> {
                println("Terimakasih telah menggunakan aplikasi ini")
                return
            }
            else -> println("Pilihan tidak valid, silahkan coba lagi")
        }
    }
}