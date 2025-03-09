// untuk membuat data class pada kotlin, cukup menambahkan tulisan data di depan class
data class User(val name: String, val age: Int)

fun main() {
    val user1 = User("John Doe", 30)
    val user2 = User("Jane Doe", 25)
    val user3 = User("John Doe", 30)

    println("User1: ${user1}")
    println("User1 == User2: ${user1 == user2}")
    println("User1 == User3: ${user1 == user3}")

//    menggunakan copy untuk membuat user4 dari user1 dengan usia yang berbeda
    val user4 = user1.copy(age=31)
    println("User4 (copy dari User1 dengan usia yang berberda): ${user4}")

//    Destructuring declaration
    val (name, age) = user1
    println("Nama dari User1 (destructuring): ${name}")
    println("Usia dari User1 (destructuring): ${age}")
}