import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private int totalRounds;
    private int currentRounds;
    private GameSetUp gameSetup;
    private GameLogic gameLogic;
    private GameResult gameResult;
    private ArrayList<PlayerObject> players;

public void start(){
    Scanner scr = new Scanner(System.in);
    PlayerChoices choices = new PlayerChoices(); // we need PlayerCHoices to have 1 owner and not buidl it to everyone
    
    gameSetup = new GameSetUp(scr, choices);     // delegates to setup
    players = gameSetup.buildPlayers();
    
    System.out.print("Enter number of rounds: ");
    totalRounds = scr.nextInt();
    scr.nextLine();
    
    gameLogic = new GameLogic(choices);          // delegates to logic
    gameResult = new GameResult();
    currentRounds = 0;

    while(!isMatchOver()){
        playRound();
        currentRounds++;
    }
    gameLogic.displayFinalResults();
}

public void playRound(){
    gameLogic.playRound(currentRounds + 1); 
}

    public boolean isMatchOver(){
        return currentRounds >= totalRounds;
    }
}