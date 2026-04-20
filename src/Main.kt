import java.lang.Thread.sleep
import java.util.*
import kotlin.math.sign

val boardCells = mutableListOf<Char>()
val players = mutableListOf<String>()
val boardSize = 16
val p1Score = 0
val p2Score = 0
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
            userNameSelect()
            gameMain()
        }

        'E' -> {
            println("Goodbye!")
        }
    }
}

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
    val player1 = readln()
    players.add(player1)

    println("Enter your name (Player2): ")
    val player2 = readln()
    players.add(player2)


}

fun boxCreate() {

    for (i in 1..boardSize) {
        print("   $i".padEnd(8))
    }

    println()

    print("┏")
    print(  "━━━━━━━┳".repeat(boardCells.size - 1))
    println(  "━━━━━━━┓")

    boardCells.forEach {
        print("┃   $it   ")
    }

    print("┃")
    println()
    print("┗")
    print("━━━━━━━┻".repeat(boardCells.size - 1))
    println(  "━━━━━━━┛")

}

fun boardCellItems(){
    val whitePc = 4
    val blackPc = 1
    val blankPieces = whitePc + blackPc

    repeat(boardSize - blankPieces) {
        boardCells.add('-')
    }
    repeat(blackPc){
        boardCells.add('*')
    }
    repeat(whitePc){
        boardCells.add('o')
    }
}

//fun playerScore(){
//
//}

fun playerInput(){

}

fun playersTurn(){
    val temp = players[0]
    players[0] = players[1]
    players[1] = temp
}

fun gameMain(): Int {
    //Randomising who starts:
    players.shuffle()
    println("${players.first()} is starting.")

    //Board item piece creation and random placement
    boardCellItems()
    boardCells.shuffle()

    while(p1Score < 1 || p2Score < 1) {
        boxCreate()

        var choice: Int?
        while (true) {

            println("${players.first()}, please select a piece from the board to move. ")
            choice = readlnOrNull()?.trim()?.toIntOrNull()
            if (choice != null && choice > 1 && choice < boardSize-2) {
                println("Where would you like to move this piece, choose a place on the board.")
                val playerMovePc = readlnOrNull()?.trim()?.toIntOrNull()

                if (playerMovePc != null && playerMovePc > 1 && playerMovePc < boardSize-2) {
                    if ((choice - playerMovePc).sign == -1){
                        Collections.swap(boardCells, choice - 1 , playerMovePc - 1)
                    }
                    print("You cannot move to the right, you must move pieces to the left. ")
                }
            }

            if (choice != null && choice in 1..boardSize) break
            println("Select a valid option\n")
        }
        playersTurn()
        println("${players.first()}'s turn.")
    }
    return 0
}
