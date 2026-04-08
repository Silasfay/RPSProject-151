import java.util.ArrayList;

public class GameManager {
    private int totalRounds;
    private int currentRound;
    private GameLogic gameLogic;
    //private GameResult gameResult;
    private ArrayList<PlayerObject> players;
    private PlayerChoices choices;

    // inner class to pass round results back to controller
    public static class RoundResult {
        public String humanChoice;
        public String computerChoice;
        public String predictedChoice;
        public String winner;
        public int humanWins;
        public int computerWins;
        public int ties;
        public String overallWinner;
    }

    public GameManager(int totalRounds){
        this.totalRounds = totalRounds;
        this.currentRound = 0;
        this.choices = new PlayerChoices();
        //this.gameResult = new GameResult();
        this.gameLogic = new GameLogic(choices);

        // set up players — default human vs ML computer
        GameSetUp setup = new GameSetUp(choices);
        this.players = setup.buildPlayers();
    }

    public RoundResult playRound(String humanChoice){
    currentRound++;

    // set human player choice
    players.get(0).setChoice(humanChoice);

    // get computer choice this also sets lastPrediction inside ML algorithm
    String computerChoice = players.get(1).makeSelection();

    // get prediction that was set during makeSelection()
    String predicted = gameLogic.getPrediction(players.get(1));

    // evaluate round through gameLogic single source of truth for scoring
    String roundResult = gameLogic.evaluateRound(humanChoice, computerChoice);

    // record round for ML computer choice first, human choice second
    players.get(1).getLogic().recordRound(computerChoice, humanChoice);

    // build result object from gameLogic's results
    GameResult gameResult = gameLogic.getResults();
    RoundResult result = new RoundResult();
    result.humanChoice = humanChoice;
    result.computerChoice = computerChoice;
    result.predictedChoice = predicted != null ? predicted : "Not enough data";
    result.winner = roundResult;
    result.humanWins = gameResult.getPlayer1Wins();
    result.computerWins = gameResult.getPlayer2Wins();
    result.ties = gameResult.getTies();
    result.overallWinner = gameResult.calculateWinner() > 0 ?
        players.get(0).getName() :
        gameResult.calculateWinner() < 0 ?
        players.get(1).getName() : "Draw";

    return result;
}

    public boolean isMatchOver(){
        return currentRound >= totalRounds;
    }

    public int getCurrentRound(){
        return currentRound;
    }

    public void saveData(){
        for(PlayerObject p : players){
            p.getLogic().saveData();
        }
    }
}