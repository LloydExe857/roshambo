fun main() {
    // Start by making the player and the computer exist
    val player1 = Player()
    println("What is your name?")
    player1.getName(readLine()?: "Player")
    val computerPlayer = ComputerPlayer()
    // These first few lines make it so you can play again
    var playAgain = "y"
    while (playAgain.lowercase() == "y") {
        playGame(player1,computerPlayer)

        playAgain = replay()
    }
    println("Thanks for playing!")
}

// Has both players decide their signs
fun playGame(player1: Player,computerPlayer: ComputerPlayer) {
    while(player1.wins < 2 && computerPlayer.wins < 2){
        println("\nBest two out of three!")
        player1.chooseSign()
        computerPlayer.chooseSign()
        println("\n${player1.name} uses ${player1.sign}")
        println("${computerPlayer.name} uses ${computerPlayer.sign}")
        calculateWin(player1,computerPlayer)
    }
    if (player1.wins >= 2)
        println("\n${player1.name} wins!")
    else
        println("\n${computerPlayer.name} wins!")

    // Clear those points in case the user wants to play again
    player1.clearPoints()
    computerPlayer.clearPoints()
}

// Calculates if a player has won
fun calculateWin(player1: Player, computerPlayer: ComputerPlayer) {
    var tied = false
    var userWins = false
    if (player1.sign == computerPlayer.sign) {
        println("Tie!")
        tied = true
    } else if (player1.sign == "rock")
        if (computerPlayer.sign == "scissors") {
            println("Rock beats scissors.")
            userWins = true
        } else {
            println("Paper beats rock")

        }
    else if (player1.sign == "paper")
        if (computerPlayer.sign == "rock") {
            println("Paper beats rock.")
            userWins = true
        } else {
            println("Scissors beat paper.")

        }
    else if (player1.sign == "scissors")
        if (computerPlayer.sign == "paper") {
            println("Scissors beat paper.")
            userWins = true
        } else {
            println("Rock beats paper.")

        }
    if (!tied) {
        if (userWins) {
            println("Point ${player1.name}!")
            player1.addWins()
        } else {
            println("Point ${computerPlayer.name}!")
            computerPlayer.addWins()
        }
    }
}

/*
///////////////////////////////////////////////////
Ask the user if they would like to play again
///////////////////////////////////////////////////
*/
fun replay(): String {
    print("Would you like to play again? (y/n) ")
    val playAgain = readLine()?.lowercase()
    if (playAgain != "y" && playAgain != "n")
        println("I guess not")
    return playAgain.toString()
}