//    Secara default, kelas di kotlin bersifat final (tidak bisa diwariskan)
//    untuk mengizinkan pewarisan, perlu mengawali sebuh class dengan keyword "open"

open class PersonNew(var name: String, var age: Int) {
    open fun introduceSelf() {
        println("Halo, nama saya ${this.name}, usia saya ${this.age} tahun")
    }
}

//  class student mewarisi dari person
class Student(name: String, age: Int, var studentId: String) : PersonNew(name, age) {

    // override fungsi introduceself dari superclass
    override fun introduceSelf() {
        println("Halo, nama saya ${this.name}, usia saya ${this.age} tahun, dan ID siswa saya adalah ${this.studentId}")
    }

    fun study() {
        println("${this.name} sedang belajar")
    }
}

fun main() {
    val person = PersonNew("Alice", 20)
    val student = Student("Bob", 17, "S1234")

    person.introduceSelf()
    student.introduceSelf()

//    Student bisa mengakases properti dan method dari PersonNew dan Stundent
    println("Nama siswa: ${student.name}")
    student.study()
}