public class GameResult {
    private int player1Wins;
    private int player2Wins;
    private int ties;

    public GameResult(){
        player1Wins = 0;
        player2Wins = 0;
        ties = 0;
    }

    public int getPlayer1Wins() { return player1Wins; }
    public int getPlayer2Wins() { return player2Wins; }
    public int getTies() { return ties; }

    public int calculateWinner(){
        return player1Wins - player2Wins;
    }

    public String updateScore(String player1Choice, String player2Choice, PlayerChoices playerChoices){
        if(playerChoices.determineWhoBeatsWho(player1Choice, player2Choice)){
            player1Wins++;
            return "Human Wins!";
        } else if(playerChoices.determineWhoBeatsWho(player2Choice, player1Choice)){
            player2Wins++;
            return "Computer Wins!";
        }
        ties++;
        return "Tie!";
    }
}