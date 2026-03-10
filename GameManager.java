import java.util.List;
import java.util.Scanner;

public class GameManager {
    private int totalRounds;
    private int currentRounds;
    private GameSetUp gameSetup;
    private GameLogic gameLogic;
    private GameResult gameResult;
    private List<PlayerObject> players;

    public void start(){
        Scanner scr = new Scanner(System.in);
        gameSetup = new GameSetUp(scr);
        players = gameSetup.buildPlayers();

        System.out.print("Enter number of rounds: ");
        totalRounds = scr.nextInt();
        scr.nextLine(); // clear buffer

        gameLogic = new GameLogic();
        gameResult = new GameResult();
        currentRounds = 0;

        while(!isMatchOver()){
            playRound();
            currentRounds++;
        }

        gameResult.displayWinner();
    }

    public void playRound(){
        System.out.println("\n--- Round " + (currentRounds + 1) + " ---");
        gameLogic.runGame(); // using your groupmate's implementation for now
    }

    public boolean isMatchOver(){
        return currentRounds >= totalRounds;
    }
}