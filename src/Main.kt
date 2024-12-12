import java.io.File

fun main() {
    val filePath = File("E:/.projects/zzzData")
    var expenseList = hashMapOf<String, Int>()
    var sum = 0

    while(true) {
        println("Describe your expense. Enter 'x' to quit the program.")
        var description = readLine()
        var price: Int? = null

        if (description!!.lowercase() == "x"){
            break
        }

        while (price == null) {
            println("Enter the price of your expense.")
            price = readLine()?.toIntOrNull()

            if (price != null) {
                break
            }
            print("Entered price was not an number. ")
        }

        if (price != null) {
            expenseList[description] = price
            sum += price
        }

        for (expense in expenseList) {
            println("${expense.key}: ${expense.value}")
        }
        println("Total sum: $sum")
    }
}