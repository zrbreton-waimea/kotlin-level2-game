import java.lang.Thread.sleep
import java.util.*
import kotlin.math.sign

val boardCells = mutableListOf<Char>()
val players = mutableListOf<String>()
val playersScore = mutableListOf<String>()
val won = mutableListOf<String>()
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
    println("┌──────────────────────────────┐".magenta())
    println("│~        Game: Pinned!       ~│".magenta())
    println("└──────────────────────────────┘".magenta())
    println("Welcome to Pinned!".cyan())
    sleep(1000)
    println("Please read through the rules before playing the game, you will need 2 players.".cyan())
    val choice = userOptions()
    when (choice) {
        'P' -> {
            userNameSelect()
            gameMain()
        }

        'E' -> {
            println("Thanks for stopping by!".cyan())
        }
    }
}

fun userOptions(): Char {
    println("Would you like to start the game?".cyan())
    println("[E]xit".cyan())
    println("[P]lay".cyan())

    var choice: Char?
    while (true) {
        print("Choice: ".cyan())
        choice = readlnOrNull()?.trim()?.firstOrNull()?.uppercaseChar()
        if (choice != null && choice in "PE") break
        println("Select a valid choice\n".cyan())
        println("Would you like to start the game?".cyan())
        println("[E]xit".cyan())
        println("[P]lay".cyan())
    }

    return choice
}

fun userNameSelect(){
    println("Enter your name (Player1): ".cyan())
    val player1 = readln()
    players.add(player1)

    println("Enter your name (Player2): ".cyan())
    val player2 = readln()
    players.add(player2)


}

fun boxCreate() {

    for (i in 1..boardSize) {
        print("   $i".padEnd(8).yellow())
    }

    println()

    print("┏".magenta())
    print(  "━━━━━━━┳".repeat(boardCells.size - 1).magenta())
    println(  "━━━━━━━┓".magenta())

    boardCells.forEach {
        print("┃".magenta())
        print("   $it   ".cyan())

    }

    print("┃".magenta())
    println()
    print("┗".magenta())
    print("━━━━━━━┻".repeat(boardCells.size - 1).magenta())
    println(  "━━━━━━━┛".magenta())

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

fun playersTurn(){
    var currentPlayer = players[0]

    if (currentPlayer == players[0]){
        currentPlayer = players[1]
    }
    else{
        currentPlayer = players[0]
    }
}

fun playerBoardInput(){

}
fun gameMain(): Int {
    //Randomising who starts:
    players.shuffle()
    println("${players.first()} is starting.")

    //Board item piece creation and random placement
    boardCellItems()
    boardCells.shuffle()

    while(true) {
        boxCreate()

        var choice: Int?
        while (true) {

            println("${players.first()}, please select a piece from the board to move. ")
            choice = readlnOrNull()?.trim()?.toIntOrNull()

            // Check to see if a coin is being removed
            if (choice != null && choice == 1 ) {
                val winPc = boardCells[0]
                boardCells[0] = '-'


                // Was it the winning coin?
                if (winPc == '*') {
                    if ( == )
                }
            }



            // Not removing, so check if it's a ,mmove
            if (choice != null && choice > 1 && choice < boardSize-2) {
                println("Where would you like to move this piece, choose a place on the board.")
                val playerMovePc = readlnOrNull()?.trim()?.toIntOrNull()

                if (playerMovePc != null && playerMovePc > 1 && playerMovePc < boardSize-2) {
                    if ((choice - playerMovePc).sign == 1){
                        Collections.swap(boardCells, choice - 1 , playerMovePc - 1)
                    }
                    else{
                        println("You cannot move to the right or on top of another piece, you must move pieces to the left. ".red())
                    }
                }
            }

            if (choice != null && choice in 1..boardSize) break
            println("Select a valid option.\n".red())
        }
        playersTurn()
        println("${players.first()}'s turn.")
    }
    return 0
}
