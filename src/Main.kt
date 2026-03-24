import java.lang.Thread.sleep
val boardCell = mutableListOf<String>()
val players = mutableListOf<String>()
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
        val action: Char = readln().first().uppercaseChar()
        when (action) {
            'C' -> {
                boxDrawBlank()
                userNameSelect()
                gameStart()
            }

            'E' -> {
                println("Goodbye!")
                break
            }

            if (userStart() != null) -> {
                println("Please select a valid input!")
                userOptions()
            }
        }
    }
}
fun userOptions(){
    println("Would you like to start the game?")
    println("[E]xit")
    println("[C]ontinue")
}

fun userNameSelect(){
    println("Enter your name (Player1): ")
    var userName1 = readln()
    players.add(userName1)

    println("Enter your name (Player2): ")
    var userName2 = readln()
    players.add(userName2)

}

fun gameStart(){
    //Randomising who starts:
    players.shuffle()
    print("${players.first()} is starting.")


}

fun boxDrawBlank(){
    println("╔════════╗".repeat(16))
    println("║   ⬛  ║".repeat(16))
    println("╚════════╝".repeat(16))

    println("╔════════╗".repeat(16))
    println("║   ⬜  ║".repeat(16))
    println("╚════════╝".repeat(16))
}


fun userStart(): Char {
    val start: Char = readln().first().uppercaseChar()
    return start
}