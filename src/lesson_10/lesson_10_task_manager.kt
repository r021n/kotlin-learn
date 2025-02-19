package lesson_10

data class Task(
    val id: Int,
    val title: String,
    val description: String? = null,
    val dueDate: String? = null,
    var isCompleted: Boolean = false
)

fun addTask(tasks: MutableList<Task>) {
    val id = tasks.size + 1
    print("Masukkan judul tugas: ")
    val title = readLine() ?: ""
    print("Masukkan deskripsi tugas (opsional): ")
    val desc = readLine()
    print("Masukkan tanggal jatuh tempo tugas (format DD/MM/YYYY): ")
    val dueDate = readLine()

    val newTask = Task(id, title, desc, dueDate)
    tasks.add(newTask)
    println("Tugas ${newTask.title} berhasil ditambahkan")
}

fun viewTasks(tasks: List<Task>) {
    if (tasks.isEmpty()) {
        println("Daftar tugas kosong")
        return
    }

    println("\n-------Daftar tugas-------")
    for (task in tasks) {
        val status = if (task.isCompleted) "[Selesai]" else "[Belum selesai]"
        println("${task.id}.\t ${task.title}\t $status")
    }
    println("----------------------------\n")
}

fun markCompleted(tasks: MutableList<Task>) {
    viewTasks(tasks)
    if (tasks.isEmpty()) return

    print("Masukkan id task yang ingin ditandai selesai: ")
    val inputId = readLine()
    inputId?.toIntOrNull() ?. let { id ->
        tasks.find { it.id == id } ?.let {
            it.isCompleted = true
            println("Task dengan id $id berhasil ditandai selesai")
        } ?: println("Maaf, task tersebut tidak dapat ditemukan")
    } ?: println("Input tidak valid, masukkan id yang benar")
}

fun viewDetail(tasks: List<Task>) {
    viewTasks(tasks)
    if (tasks.isEmpty()) return

    print("Masukkan id tugas yang ingin dilihat: ")
    val idInput = readLine()
    idInput?.toIntOrNull() .let { id ->
        tasks.find { it.id == id } ?.let {
            println("\n------Detail tugas-----")
            println("Title: ${it.title}")
            println("Description: ${it.description}")
            println("Due date: ${it.dueDate}")
            val status = if (it.isCompleted) "Selesai" else "Belum selesai"
            println("Status: ${status}")
        } ?: println("Maaf, tidak ada task seperti itu")
    }
}

fun main() {
    val tasks = mutableListOf<Task>()

    while(true) {
        println("\n-------Aplikasi pengelolaan tugas-------")
        println("1. Tambah tugas")
        println("2. Lihat daftar tugas")
        println("3. Tandai tugas selesai")
        println("4. Lihat detail tugas")
        println("5. Keluar")
        print("Masukkan pilihanmu (1-5): ")

        when(readLine()) {
            "1" -> addTask(tasks)
            "2" -> viewTasks(tasks)
            "3" -> markCompleted(tasks)
            "4" -> viewDetail(tasks)
            "5" -> {
                println("Terimakasih sudah menggunakan aplikasi ini")
                return
            }
            else -> println("Masukkan tidak valid, silahkan coba lagi")
        }
    }
}