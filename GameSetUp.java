import java.util.ArrayList;
import java.util.Scanner;

public class GameSetUp {
    private Scanner scr;
    private PlayerFactory factory;
    private PlayerChoices choices;
    private String computerMode; //null if no override

    public GameSetUp(Scanner scan, PlayerChoices choices, String computerMode){
        this.scr = scan;
        this.choices = choices;
        this.computerMode = computerMode;
        this.factory = new PlayerFactory(scr, choices);
    }

    public String setPlayerName(){
        System.out.println("Enter Player Name:");
        return scr.nextLine();
    }

// just asks, moved all logic to factory
private String setPlayerType(String name){
    System.out.print("Is " + name + " Human, Random Computer, or Trained Computer? (H/RC/TC): ");
    String input = scr.nextLine().trim().toUpperCase();
    
        if(input.equals("H") || input.equals("RC") || input.equals("TC")){
            return input;
        }
        System.out.println("Invalid input. Please enter H, RC, or TC.");
}

//passes string to factory
public ArrayList<PlayerObject> buildPlayers(){
    ArrayList<PlayerObject> playerList = new ArrayList<>();
    for(int i = 0; i < 2; i++){
        String name = setPlayerName();
        String type = setPlayerType(name);
        playerList.add(factory.createPlayer(name, type, computerMode));
    }
    return playerList;
}
}
