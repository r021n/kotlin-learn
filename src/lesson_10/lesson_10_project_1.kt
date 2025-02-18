package lesson_10

data class User(val name: String?, val age: Int?)

fun displayUserInfo(user: User?) {
    user?.let {
        println("Nama: ${it.name ?: "tidak diketahui"}")
        println("Umur: ${it.age ?: "tidak diketahui"} tahun")
    } ?: println("Data user tidak diketahui")
}

fun main() {
    val user1 = User("Alice", 23)
    val user2 = User(null, 30)
    val user3 = User("Bambang", null)
    val user4: User? = null

    println("\nInformasi user 1")
    displayUserInfo(user1)

    println("\nInformasi user 2")
    displayUserInfo(user2)

    println("\nInformasi user 3")
    displayUserInfo(user3)

    println("\nInformasi user 4")
    displayUserInfo(user4)
}