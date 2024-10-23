import java.util.Scanner;

val activity: Array<String?> = arrayOfNulls(10)
val inputUser = Scanner(System.`in`)
//Show To Do List
fun ShowToDoList(todo: String) {
    println("===== TO DO LIST HARI INI ======")
    for (i in activity.indices){
        if (i == null){
            return
        }else{
            println("${i + 1}. $todo")
            break
        }
    }
}

fun TestShowToDoList() {
    val aktivitas = "Belajar"

    ShowToDoList(aktivitas)

}

fun AddToDoList() {

}

fun EditToDoList() {

}

fun RemoveToDoList() {

}

fun UIAddToDoList() {

}

fun UIEditToDoList() {

}

fun UIRemoveToDoList() {

}
    fun main() {
        // MAIN PROGRAM
        TestShowToDoList()
}