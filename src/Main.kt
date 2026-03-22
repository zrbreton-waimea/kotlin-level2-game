import java.lang.Thread.sleep
val boardCell = mutableListOf<String>()
/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Pinned!
 * Project Author: Zander Breton
 * GitHub Repo:    https://github.com/zrbreton-waimea/kotlin-level2-game
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */



fun main() {
    println("┌──────────────────────────────┐")
    println("│~        Game: Pinned!       ~│")
    println("└──────────────────────────────┘")
    println("Welcome to Pinned!")
    sleep(1000)
    println("Please read through the rules before playing the game, you will need 2 players.")

    userOptions()


    while (true) {
        val action = userStart()
        when (action) {
            'C' -> boxDrawBlank()
            'E' -> {
                println("Goodbye!")
                break
            }
            else -> {
                println("Please select a valid input!")
                return userOptions()
            }
        }
    }
}
fun userOptions(){
    println("Would you like to start the game?")
    println("[E]xit")
    println("[C]ontinue")
}

fun boxDrawBlank(){
    println("╔════════╗".repeat(15))
    println("║        ║".repeat(15))
    println("╚════════╝".repeat(15))
}


fun userStart(): Char {
    val start: Char = readln().first().uppercaseChar()
    return start
}