public class GameLogic {
    private PlayerChoices choices;
    private GameResult results;

    public GameLogic(PlayerChoices choices){
        this.choices = choices;
        this.results = new GameResult();
    }

    // called by controller — takes choices as strings, returns round result string
    public String evaluateRound(String humanChoice, String computerChoice){
        // Get round results
        String roundResult = results.updateScore(humanChoice, computerChoice, choices);

        // print to console for debugging
        System.out.println("Human chose: " + humanChoice);
        System.out.println("Computer chose: " + computerChoice);
        System.out.println("Round Result: " + roundResult);
        System.out.println("Score - Human: " + results.getPlayer1Wins() + 
                           " Computer: " + results.getPlayer2Wins() +
                           " Ties: " + results.getTies());

        return roundResult;
    }

    // gets ML prediction before round is played
    public String getPrediction(PlayerObject player){
        if(player.getLogic() instanceof ComputerLogic){
            ComputerAlgorithm algo = ((ComputerLogic) player.getLogic()).getAlgorithm();
            if(algo instanceof MachineLearningAlgorithm){
                return ((MachineLearningAlgorithm) algo).getLastPrediction();
            }
        }
        return "Random";
    }

    public GameResult getResults(){
        return results;
    }

    // Display final overall score
    public void displayFinalResults(){
        int resultingScore = results.calculateWinner();
        if(resultingScore > 0){
            System.out.println("Human won the game!");
        } else if(resultingScore < 0){
            System.out.println("Computer won the game!");
        } else {
            System.out.println("Draw!");
        }
    }
}