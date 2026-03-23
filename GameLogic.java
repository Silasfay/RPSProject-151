public class GameLogic {
    private PlayerChoices choices;
    private GameResult results;
    private Logger logger;

    public GameLogic(PlayerChoices choices){
        this.choices = choices;
        this.results = new GameResult();
        this.logger = logger;
    }

    public void playRound(int roundNumber, PlayerObject player1, PlayerObject player2) {
        System.out.println("\nRound " + roundNumber);

        // get moves from PlayerObject instead of directly from logic classes
        String player1Choice = player1.makeSelection();
        String player2Choice = player2.makeSelection();
        
        //current round choices
        System.out.println(player1.getName() + " chose: " + player1Choice);
        System.out.println(player2.getName() + " chose: " + player2Choice);
        
        //Get round results
        String roundResult = results.updateScore(player1Choice, player2Choice, choices);
        System.out.println("Round Result: " + roundResult);

        // Display current score
        System.out.println("Current Score:");
        System.out.println(player1.getName() + ": " + results.getPlayer1Wins());
        System.out.println(player2.getName() + ": " + results.getPlayer2Wins());

        // Train ML models
        player1.getLogic().recordRound(player1Choice, player2Choice);
        player2.getLogic().recordRound(player2Choice, player1Choice);
    }

    // Display final overall score
    public void displayFinalResults(){
        int resultingScore = results.calculateWinner();
        if(resultingScore > 0) {
            System.out.println("Player 1 won the game!");
        }
        else if(resultingScore < 0) {
            System.out.println("Player 2 won the game!");
        }
        else {
            System.out.println("Draw!");
        }
    }
}
