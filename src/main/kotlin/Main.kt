import java.util.Scanner
import kotlin.system.exitProcess

class Item(newName: String, newStore: String) {
    // Create variables for the item class
    private var itemName: String
    var store: String
    var obtained: Boolean
    val id: Int

    // This creates an incrementing counter for the id such
    // that a new id is automatically created for each new
    // instance of the item class
    companion object {
        private var nextId = 1

        fun getNextId(): Int {
            return nextId++
        }
    }

    // Initialize the class with user-inputted variables and
    // establish the ID
    init {
        itemName = newName
        store = newStore
        obtained = false

        id = getNextId()
    }

    // Display the item in a shopping list format, displaying
    // an empty box if not obtained and a check mark if
    // obtained
    fun display() {
        if (obtained) {
            print("✓")
        }
        else {
            print("▢")
        }

        print(" $itemName \n  ID: $id \n")
    }

    // Mark the item as obtained
    fun checkOff() {
        obtained = true;
    }
}

// Display the entire shopping list and group the items by
// store
fun displayShoppingList(shoppingList: MutableList<Item>) {
    val groupedItems = shoppingList.groupBy { it.store }

    print("\n")
    for ((store, itemList) in groupedItems) {
        println("$store:")
        for (item in itemList) {
            item.display()
        }
    }
    print("\n")
}

// Gather user input and add a new item by ID
fun addItem(shoppingList: MutableList<Item>) {
    print("Enter the item name: ")
    val nameInput = readln()

    print("Enter the store to shop from: ")
    val storeInput = readln()

    val newItem = Item(nameInput, storeInput)
    shoppingList.add(newItem)

    println("$nameInput successfully added!")

    displayShoppingList(shoppingList)
}

// Get user input and delete an item by ID
fun removeItem(shoppingList: MutableList<Item>) {
    val reader = Scanner(System.`in`)
    displayShoppingList(shoppingList);

    print("Provide the id of the item you would like to remove: ")
    val idInput:Int = reader.nextInt()

    val itemRemoved = shoppingList.removeIf { it.id == idInput }

    if (itemRemoved) {
        println("Item with ID $idInput was removed.")
    } else {
        println("Item with ID $idInput was not found in the list.")
    }

    displayShoppingList(shoppingList);
}

// Remove all items that the user has checked off
fun removeCheckedItems(shoppingList: MutableList<Item>) {
    shoppingList.removeIf { it.obtained }

    displayShoppingList(shoppingList)
}

// Gather user input and check off an item by ID
fun checkItem(shoppingList: MutableList<Item>) {
    val reader = Scanner(System.`in`)
    displayShoppingList(shoppingList);

    print("Provide the id of the item you would like to check off: ")
    val idInput:Int = reader.nextInt()

    val foundItem = shoppingList.find { it.id == idInput }

    if (foundItem != null) {
        if (foundItem.obtained) {
            println("That item is already checked off")
        } else {
            foundItem.checkOff();
            println("Item checked off!")
        }
    } else {
        println("Item with $idInput was not found")
    }

    displayShoppingList(shoppingList);
}

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    println("Welcome to the shopping list!");

    // Sample Data
    val shoppingList: MutableList<Item> = mutableListOf(
        Item("Chips", "Walmart"),
        Item("Milk", "Broulim's"),
        Item("Zelda: Tears of the Kingdom", "Target"),
        Item("Headphones", "Target"),
        Item("Notebook", "Walmart"),
        Item("Sushi", "Broulim's"),
        Item("Stew Meat", "Broulim's"),
        Item("Bread", "Walmart"),
        Item("Eggs", "Walmart")
    )

    var option = 1;

    // Menu options
    while (option != 0) {
        println("Menu: \n1.) View List \n2.) Add Item \n3.) Remove Item \n4.) Remove All Checked Items \n5.) Check Item \n0.) Quit Program");
        print("Your choice: ")
        val input:Int = reader.nextInt();
        option = input;

        when (option) {
            1 -> displayShoppingList(shoppingList)
            2 -> addItem(shoppingList)
            3 -> removeItem(shoppingList)
            4 -> removeCheckedItems(shoppingList)
            5 -> checkItem(shoppingList)
            0 -> {
                println("Thank you for using the shopping list app!")
            }
        }
    }

    exitProcess(0)
}