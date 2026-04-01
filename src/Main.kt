import java.lang.Thread.sleep
val boardCells = mutableListOf<Char>()
val players = mutableListOf<String>()
val boardSize = 16
//Change to alter board size
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

    val choice = userOptions()
    when (choice) {
        'C' -> {
            //boxDrawBlank.()
            userNameSelect()
            gameStart()
        }

        'E' -> {
            println("Goodbye!")
        }
    }
}

fun boxDrawBlank(board: MutableList<Char>) {
    println(  "╔═════════╗".repeat(board.size))
    board.forEach {
        print("║    a    ║")
    }
    println(  "╚═════════╝".repeat(board.size))
}
//╔═════════╗
//║  value  ║
//╚═════════╝

fun userOptions(): Char {
    println("Would you like to start the game?")
    println("[E]xit")
    println("[C]ontinue")

    var choice: Char?
    while (true) {
        print("Choice: ")
        choice = readlnOrNull()?.trim()?.firstOrNull()?.uppercaseChar()
        if (choice != null && choice in "EC") break
        println("Select a valid choice\n")
        println("Would you like to start the game?")
        println("[E]xit")
        println("[C]ontinue")
    }

    return choice
}

fun userNameSelect(){
    println("Enter your name (Player1): ")
    var userName1 = readln()
    players.add(userName1)

    println("Enter your name (Player2): ")
    var userName2 = readln()
    players.add(userName2)

}


fun gameStart() {
    //Randomising who starts:
    players.shuffle()
    println("${players.first()} is starting.")

//Board drawn
    boxDrawPre()
    boardCells.shuffle()
    println("$boardCells")

}

fun boxDrawPre(){
//    println("╔═════════╗")
//    println("║         ║")
//    print("  ╚═════════╝")
    repeat(boardSize - 5){
        boardCells.add('_')
    }
    repeat(boardSize - 12){
        boardCells.add('*')
    }
    repeat(boardSize - 15){
        boardCells.add('o')
    }

}


fun userStart(): Char {
    val start: Char = readln().first().uppercaseChar()
    return start
}