import java.util.Scanner;

var activity: Array<String?> = arrayOfNulls(10)
val inputUser = Scanner(System.`in`)
//Show To Do List
fun ShowToDoList() {
    println("===== TO DO LIST HARI INI ======")
    for (i in activity.indices) {
        var todo = activity[i]
        if (todo != null){
            println("${i + 1}. $todo")
        }else{
            break
        }
    }
}

fun TestShowToDoList() {
    AddToDoList("Makan")
    AddToDoList("Makan")
    AddToDoList("Makan")
    ShowToDoList()

}

fun AddToDoList(todo: String) {
    var isFull = true
    var temp: String?
    // Function Pengecekan apakah Array Masih NULL atau tidak
    for (i in activity.indices){
        if (i == null){
            isFull = false
            break
        }
    }
    // Jika penuh kita resize
    if (isFull){
        activity = activity.copyOf(activity.size * 2)
    }
    // Menyimpan Array ke variabel sementara
    temp = activity[activity.size-1]
    // Mengganti array sementara dengan Array Permanen
    if (temp != null) {
        for (i in temp.indices){
            temp = activity[i]
            break
        }
    }

    // Menambahkan To Do ke data null
    for (i in activity.indices){
        if (activity[i] == null){
            activity[i] = todo
            break
        }
    }
}

fun TestAddToDoList() {
    AddToDoList("MAKAN")
    AddToDoList("MAKAN")
    AddToDoList("MAKAN")
    AddToDoList("MAKAN")
    AddToDoList("MAKAN")
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
    // TestAddToDoList()
}