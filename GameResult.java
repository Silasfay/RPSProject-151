public class GameResult {
    private int player1Wins; 
    private int player2Wins;

    public GameResult(){
        player1Wins = 0;
        player2Wins = 0;
    }
    //getters
    public int getPlayer1Wins() {
        return player1Wins;
    }
    public int getPlayer2Wins() {
        return player2Wins;
    }
    
    public int calculateWinner() {
        return player1Wins - player2Wins;
    }

    public String updateScore(String player1Choice, String player2Choice, PlayerChoices playerChoices) {
        // determineWhoBeatsWho is called two times, to see if player1 beats player2 and then if player2 beats player1
        // If either is false, then it is a tie
        if(playerChoices.determineWhoBeatsWho(player1Choice, player2Choice)) {
            player1Wins++;
            return "Player 1 Wins!";
        }
        else if(playerChoices.determineWhoBeatsWho(player2Choice, player1Choice)) {
            player2Wins++;
            return "Player 2 Wins!";
        }
        return "Tie!";
    }
}
