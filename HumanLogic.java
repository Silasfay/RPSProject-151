import java.util.Scanner;

public class HumanLogic implements PlayerLogic {
    private Scanner scr;
    private PlayerChoices choices;

    public HumanLogic(Scanner scan, PlayerChoices choices){
        this.scr = scan;
        this.choices = choices;
    }

    @Override
    public String getChoice(){
        while(true){
            // display choices from PlayerChoices so menu updates automatically when choices change
            choices.displayChoices();
            int selection = scr.nextInt();

            // Call the PlayerChoice method to get possible choices without hardcoding
            String resultedChoice = choices.determineChoice(selection);
            if(resultedChoice != null) {
                return resultedChoice;
            }
            System.out.println("Invalid input. Please enter an appropriate option.");
        }
    }
}
