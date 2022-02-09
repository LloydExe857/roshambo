open class Player(
    var name: String = "player",
    var sign: String = "rock",
    var wins: Int = 0
){
    // For the player to set their name
    fun getName(newName: String) {
        this.name = newName
    }

    // For the player to chose their sign
    open fun chooseSign() {
        var madeChoice = false
        while (!madeChoice) {
            println("Rock, paper, or scissors?")
            sign = readLine()?.lowercase().toString()
            if (sign != "rock" && sign != "paper" && sign != "scissors")
                println("Try again")
            else
                madeChoice = true
        }
    }

    // Totaling up rounds won
    fun addWins() {
        this.wins++
    }

    // Clear points when the game is over
    fun clearPoints() {
        wins = 0
    }
}