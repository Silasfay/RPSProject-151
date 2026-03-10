
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
    
    public void displayWinner() {
        if (player1Wins > player2Wins) {
            System.out.println("Player 1 won the game!");
        } else if (player2Wins > player1Wins) {
            System.out.println("Player 2 won the game!");
        } else {
            System.out.println("Draw!");
        }
    }

    public void updateScore(String player1Choice, String player2Choice, PlayerChoices playerChoices) {
        if (playerChoices.getBeats(player1Choice)[0].equals(player2Choice)) {
            player1Wins++;
        } else if (playerChoices.getBeats(player2Choice)[0].equals(player1Choice)) {
            player2Wins++;
        }
    }
}
