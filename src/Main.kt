import java.lang.Thread.sleep
import java.util.*

val boardCells = mutableListOf<Char>()
val players = mutableListOf<String>()
var currentPlayerIndex = 0
const val boardSize = 16 //Change to alter board size
const val usernameLimit = 13 //Change to increase or decrease the allowed username char limit
const val playerLimit = 2

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
    sleep(800)
    print("Loading rules".yellow())
    sleep(400)
    print(".")
    sleep(400)
    print(".")
    sleep(400)
    println(".")
    sleep(400)

    println("Game rules:\n" +
            "\n" +
            " Pinned \uD83D\uDCCC\n" +
            "\n" +
            "Game Setup\n" +
            "- A row of 16 squares, numbered 1 to 16 from left to right\n" +
            "- 5 counters (total) are placed randomly on the board - 4 white (*) and 1 black (o)\n" +
            "- Decide who goes first\n" +
            "\n" +
            "Gameplay\n" +
            "- Players take turns - You may not skip your turn\n" +
            "- On your turn you must do exactly one of the following:\n" +
            "  - Slide any counter black(*) or white(o) any number of squares to the left, as long as no other counter is in the way and the destination square is empty, or...\n" +
            "  - Remove the counter on square 1 (only if a counter is there)\n" +
            "\n" +
            "Win Condition\n" +
            "- The player who removes the black counter (*) from square 1 wins\n")

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

//Game start menu input handling
fun userOptions(): Char {
    println("Would you like to start the game?".cyan())
    println("[E]xit".cyan())
    println("[P]lay".cyan())

    var choice: Char?
    while (true) {
        print("Choice: ".cyan())
        choice = readlnOrNull()?.trim()?.firstOrNull()?.uppercaseChar()
        if (choice != null && choice in "PE") break
        println("Select a valid choice.".red())
        println("Would you like to start the game?".cyan())
        println("[E]xit".cyan())
        println("[P]lay".cyan())
    }

    return choice
}
//Handles username inputs and checks if they are valid.
fun userNameSelect(){
    (1..playerLimit).forEach {
        while(true){
            println("Enter your name (Player${it}): ".cyan())
            val playerUsernames = readln()
            if(playerUsernames.isBlank()) {
                println("Please choose a user name that has characters, must NOT be blank.".red())
            }

            else if(playerUsernames.length > usernameLimit) {
                println("Please choose a user name that has a maximum length of $usernameLimit characters.".red())
            }
            else{
                players.add(playerUsernames)
                break
            }
        }
    }
}
//This function draws the board, this will change with the size of the board.
fun boxDraw() {

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
//This function adds the necessary pieces to the board.
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
    currentPlayerIndex = if (currentPlayerIndex == 0){
        1
    }
    else{
        0
    }
}

fun gameMain() {
    //Randomising who starts:
    currentPlayerIndex = (0..1).random()

    println("${players[currentPlayerIndex]} is starting.")

    //Board item piece creation and random placement
    boardCellItems()
    boardCells.shuffle()

    var playerHasWon = false

    while(!playerHasWon) {
        boxDraw()

        // Input loop - will repeat until valid move
        var playerPieceSelect: Int?
        while (!playerHasWon) {
            var invalidJump = false
            var invalidMoveRight = false
            var invalidMoveOntop = false

            println("${players[currentPlayerIndex]}, please select a piece from the board to move. ")
            playerPieceSelect = readlnOrNull()?.trim()?.toIntOrNull()

            // Check to see if a coin is being removed
            if (playerPieceSelect != null && playerPieceSelect == 1 ) {
                val winPiece = boardCells[0]
                boardCells[0] = '-'

                // Was it the winning piece
                if (winPiece == '*') {
                    playerHasWon = true
                }
                break               // Leave input loop as turn is done.
            }

            // Checking if the players piece they selected is valid.
            if (playerPieceSelect != null && playerPieceSelect > 1 && playerPieceSelect <= boardSize && boardCells[playerPieceSelect-1] != '-') {
                println("Where would you like to move this piece, choose a place on the board.")
                val playerPieceMove = readlnOrNull()?.trim()?.toIntOrNull()
                if (playerPieceMove != null && playerPieceMove in 1..<boardSize) {

                    if(boardCells[playerPieceMove-1] == 'o' || boardCells[playerPieceMove-1] == '*') {
                        println("You cannot move on top of another piece.".red())
                        invalidMoveOntop = true
                    }

                    //Checking whether player has jumped over a piece.
                    if (playerPieceMove < playerPieceSelect && boardCells[playerPieceMove-1] != 'o' && boardCells[playerPieceMove-1] != '*') {
                        //If the player makes no illegal moves, then the piece is moved.
                        for(i in playerPieceMove..<playerPieceSelect-1){
                            if(!invalidJump && boardCells[i] == 'o' || boardCells[i] == '*') {
                                println("You cannot jump over other pieces on the board.".red())
                                invalidJump = true
                            }
                        }
                    }


                    else if(playerPieceMove >= playerPieceSelect){
                        println("You cannot move to the right. You MUST move pieces to the left. ".red())
                        invalidMoveRight = true
                        boxDraw()
                    }

                    if(!invalidJump && !invalidMoveRight && !invalidMoveOntop) {
                        Collections.swap(boardCells, playerPieceSelect - 1 , playerPieceMove - 1)
                        break
                    }
                }

                else {
                    println("Select a valid option.\n".red())
                }
            }

            else{
                println("Please enter a valid input, choose a piece to move.".red())
            }
        }

            if (playerHasWon)
            {
                println("${players[currentPlayerIndex]} has won! Congrats! (*^▽^*)")
                break
            }        // Winning player has been decided so break out of main loop.

        playersTurn()
        println("${players[currentPlayerIndex]}'s turn.")
    }
}
