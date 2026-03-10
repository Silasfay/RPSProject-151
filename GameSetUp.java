import java.util.ArrayList;
import java.util.Scanner;

public class GameSetUp {
    private Scanner scr;
    private PlayerFactory factory;
    private PlayerChoices choices;  

    public GameSetUp(Scanner scan, PlayerChoices choices){
        this.scr = scan;
        this.choices = choices;
        this.factory = new PlayerFactory(scr, choices);
    }

    public String setPlayerName(){
        System.out.println("Enter Player Name:");
        return scr.nextLine();
    }

    private PlayerLogic setPlayerType(String name){
        System.out.print("Is " + name + " Human or Computer? (H/C): ");
        String input = scr.nextLine().trim().toUpperCase();
        if(input.equals("H")) return new HumanLogic(scr);
        return new ComputerLogic(choices.getChoices());
    }

    public ArrayList<PlayerObject> buildPlayers(){ 
        ArrayList<PlayerObject> playerList = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            String name = setPlayerName();
            PlayerLogic logic = setPlayerType(name); 
            playerList.add(factory.createPlayer(name, logic)); 
        }
        return playerList;
    }
}