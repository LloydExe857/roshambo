import kotlin.random.Random

class ComputerPlayer : Player() {
    init {
        name = "Computer"
    }

    override fun chooseSign() {
        when(Random.nextInt(0,3)){
            0 -> sign = "rock"
            1 -> sign = "paper"
            2 -> sign = "scissors"
        }
    }
}