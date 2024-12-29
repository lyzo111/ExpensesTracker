import java.io.File
import org.yaml.snakeyaml.Yaml

fun main() {
    // Get file path from yaml file
    val yaml = Yaml()
    val inputStream = File("config.yaml").inputStream()
    val config = yaml.load<Map<String, Any>>(inputStream)
    val filePath = config["file_path"] as String

    val expenseList = hashMapOf<String, Int>()
    var sum = 0

    fun printExpenseList() {
        for (expense in expenseList) {
            println("${expense.key}: ${expense.value}")
        }
        println("Total sum: $sum\n")
    }

    while(true) {
        println("\nDescribe your expense. Enter 'x' to quit the program.")
        val description = readlnOrNull()
        var price: Int? = null

        if (description == "") {
            continue
        }

        if (description!!.lowercase() == "x"){
            break
        }

        while (price == null) {
            println("Enter the price of your expense.")
            price = readlnOrNull()?.toIntOrNull()

            if (price != null) {
                break
            }
            print("Entered price was not an number. ")
        }

        if (price != null) {
            expenseList[description] = price
            sum += price
        }

        printExpenseList()
    }
    printExpenseList()
}