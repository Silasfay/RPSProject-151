import java.util.List;

public class GameManager {
    private int totalRounds;
    private int currentRounds;
    private GameSetUp gameSetup;
    private GameLogic gameLogic;
    private GameResult gameResult;
    private List<PlayerObject> players;
    
    public void start(){
        GameSetUp gameSetup = new GameSetUp();
        
    }
    public void playRound(){

    }
    public boolean isMatchOver(){
        return totalRounds == currentRounds;
    }
}
