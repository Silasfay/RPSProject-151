import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private int totalRounds;
    private int currentRounds;
    private GameSetUp gameSetup;
    private GameLogic gameLogic;
    private ArrayList<PlayerObject> players;

    public void start(){
        Scanner scr = new Scanner(System.in);
        PlayerChoices choices = new PlayerChoices(); // we need PlayerChoices to have 1 owner and not build it to everyone
        
        gameSetup = new GameSetUp(scr, choices);     // delegates to setup
        players = gameSetup.buildPlayers();
        
        System.out.print("Enter number of rounds: ");
        totalRounds = scr.nextInt();
        scr.nextLine();
        
        gameLogic = new GameLogic(choices);          // delegates to logic
        currentRounds = 0;

        while(!isMatchOver()){
            playRound();
            currentRounds++;
        }
        gameLogic.displayFinalResults();

        //save TC data
        for(PlayerObject p : players){
            if (p.getLogic() instanceof ComputerLogic){
                ((ComputerLogic) p.getLogic()).saveData();
            }
        }
    }

    public void playRound(){
        // passes both PlayerObjects to GameLogic
        gameLogic.playRound(currentRounds + 1, players.get(0), players.get(1));
    }

    public boolean isMatchOver(){
        return currentRounds >= totalRounds;
    }
}
