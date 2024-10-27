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
    if (activity.first() == null && activity.last() == null){
        println("Sepertinya Kamu Belum Punya Aktivitas Hari Ini, Tambahkan Beberapa Aktivitas")
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

fun RemoveToDoList(inputNumber: Int): Boolean {
    val Angka = inputNumber - 1
    // Pengecekan apakah Input Angka kurang dari 0 dan lebih dari size index
    if (Angka <= -1 && Angka > activity.size){
        return false
    // Pengecekan apakah Input null
    }else if(activity[Angka] == null){
        return false
    } else{
        // Looping
        for (i in activity.indices){
            // Pengecekan apakah input mendekati 0
            if (i == activity.size - 1){
                activity[i] = null
            }
            // Penggeseran penomoran
            else activity[i] = activity[i + 1]
        }
    }
    return true
}
// Unit TEST
fun TestRemoveToDoList(){
    AddToDoList("Makan")
    AddToDoList("Main")
    AddToDoList("Belajar")
    AddToDoList("Coding")
    RemoveToDoList(1)
    ShowToDoList()
}
fun EditToDoList(inputNumber: Int, inputToDo: String): Boolean {
    val Angka = inputNumber - 1
    if (Angka > activity.size){
        return false
    } else if(Angka == null){
        return false
    }else{
        activity[Angka] = inputToDo
    }
return true
}
fun TestEditToDoList() {
    AddToDoList("Makan")
    AddToDoList("Kerja")
    AddToDoList("Mandi")
    AddToDoList("Rebahan")
    ShowToDoList()
    EditToDoList(1, "Tidur")
    ShowToDoList()

}

fun UIAddToDoList() {

    println("\n========= TAMBAHKAN TO DO LIST KAMU HARI INI =========")

    print("Masukkan To Do List: ")
    val todo = inputUser.nextLine()
    if (todo == null){
        println("Input Kamu Tidak Sesuai, Silahkan isi To Do dengan teliti!!")
        return
    } else{
        AddToDoList(todo)
    }
}

fun TestUIAddToDoList() {
    UIAddToDoList()
    ShowToDoList()
}

fun UIEditToDoList() {
    println("\n========= EDIT TO DO LIST KAMU HARI INI =========")

    print("Masukkan To Do List: ")
    val todo = inputUser.nextLine()
    print("Masukkan To Do List Keberapa Yang Mau Diganti: ")
    val Num = inputUser.nextInt()

    if (todo == null){
        println("Input Kamu Tidak Sesuai, Silahkan isi To Do dengan teliti!!")
        return
    }else if (Num == null){
        println("Input Kamu Tidak Sesuai, Silahkan isi Nomor To Do List yang ingin diganti dengan teliti!!")
        return
    }
    else{
        EditToDoList(Num, todo)
    }
}

fun TestUIEditToDoList() {
    AddToDoList("Makan")
    AddToDoList("Mandi")
    AddToDoList("Tidur")
    AddToDoList("Main")
    ShowToDoList()
    UIEditToDoList()
    ShowToDoList()

}

fun UIRemoveToDoList() {
    println("\n========= HAPUS TO DO LIST KAMU HARI INI =========")

    print("Masukkan To Do List Keberapa Yang Mau DIhapus: ")
    val Num = inputUser.nextInt()

    if (Num == null){
        println("INPUT NUMBER KAMU SALAH, PERHATIKAN KEMBALI INPUT DATA!!!")
        return
    }else if (Num > activity.size){
        println("INPUT KAMU MELEBIHI BATAS DATA!!")
    }else{
        RemoveToDoList(Num)
    }
}

fun TestUIRemoveToDoList() {
    AddToDoList("Makan")
    AddToDoList("Mandi")
    AddToDoList("Tidur")
    AddToDoList("Main")
    ShowToDoList()
    UIRemoveToDoList()
    ShowToDoList()

}

fun UIAPP() {

    var kondisi = true
    while (kondisi){
        println("APP version: 1.0")
        println("Mengatur Harimu Dengan Lebih Tersusun")
        println("Selamat Datang, Ada Aktivitas Apa Hari Ini?\n")
        ShowToDoList()

        println("\n1. Tambah To Do List")
        println("2. Edit To Do List")
        println("3. Hapus To Do List")
        println("4. Keluar")

        print("Masukkan Aksi Apa Yang Mau Dilakukan Dalam Angka: ")
        val InputKegiatan = inputUser.nextInt()
        inputUser.nextLine()

        if (InputKegiatan == 1) {
            UIAddToDoList()
        } else if (InputKegiatan == 2) {
            UIEditToDoList()
        }else if (InputKegiatan == 3){
            UIRemoveToDoList()
        } else if (InputKegiatan == 4){
            println("Aplikasi Berhenti, Terimakasih")
            kondisi = false
        }
    }
}

fun main() {
    // MAIN PROGRAM
    // TestShowToDoList()
    // TestAddToDoList()
    // TestRemoveToDoList()
    // TestEditToDoList()
    // TestUIAddToDoList()
    // TestUIEditToDoList()
    // TestUIRemoveToDoList()
    UIAPP()
}