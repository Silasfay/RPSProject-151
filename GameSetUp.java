import java.util.ArrayList;
import java.util.Scanner;

public class GameSetUp {
    private Scanner scr;
    private PlayerFactory factory;
    private PlayerChoices choices;
    private String computerMode;

    public GameSetUp(Scanner scan, PlayerChoices choices){
        this.scr = scan;
        this.choices = choices;
        this.computerMode = computerMode;
        this.factory = new PlayerFactory(scr, choices);
    }

    public String setPlayerName(){
        System.out.println("Enter Player Name:");
        return scr.nextLine();
    }

    private PlayerLogic setPlayerType(String name){
        while(true){
            System.out.print("Is " + name + " Human, Random Computer, or Trained Computer? (H/RC/TC): ");
            String input = scr.nextLine().trim().toUpperCase();
            
            // pass choices to HumanLogic so it can display the menu
            if(input.equals("H")){
                return new HumanLogic(scr, choices);
              }
            // if user chooses a computer, apply command-line mode if set
            if(input.equals("RC") || input.equals("TC")){
                if(computerMode.equals("RANDOM")){
                    return new ComputerLogic(new RandomAlgorithm(choices.getChoices()));
                }
                if(computerMode.equals("ML")){
                    return new ComputerLogic(new MachineLearningAlgorithm(choices.getChoices()));
                }else {
                    // user selected type interactively
                    if(input.equals("RC")){
                        return new ComputerLogic(new RandomAlgorithm(choices.getChoices()));
                    } else {
                        return new ComputerLogic(new MachineLearningAlgorithm(choices.getChoices()));
                    }
                }
            }
            //if not H or RC or TC entered
            System.out.println("Invalid input. Please enter H for Human, RC for Random Computer, or TC for Trained Computer");
            
        }
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
