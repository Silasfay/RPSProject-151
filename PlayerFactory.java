import java.util.Scanner;

public class PlayerFactory {
    private Scanner scr;
    private PlayerChoices choices;

    public PlayerFactory(Scanner scan, PlayerChoices choices){
        this.scr = scan;
        this.choices = choices;
    }

    public PlayerObject createPlayer(String name, String type, String computerMode){
        PlayerLogic logic = buildLogic(type, computerMode);
        return new PlayerObject(name, logic);
    }

    // single place that decides which logic and algorithm to build
    private PlayerLogic buildLogic(String type, String computerMode){
        if(type.equals("H")){
            return new HumanLogic(scr, choices);
        }

        // handle computer mode override from command line
        if(computerMode != null){
            System.out.println("Command-line override: using " + computerMode + " algorithm");
            if(computerMode.equals("RANDOM")){
                return new ComputerLogic(new RandomAlgorithm(choices.getChoices()));
            }
            if(computerMode.equals("ML")){
                return new ComputerLogic(new MachineLearningAlgorithm(choices.getChoices()));
            }
        }

        // no override, use what user selected
        if(type.equals("TC")){
            return new ComputerLogic(new MachineLearningAlgorithm(choices.getChoices()));
        }
        return new ComputerLogic(new RandomAlgorithm(choices.getChoices()));
    }
}