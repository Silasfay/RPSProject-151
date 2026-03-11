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
        // display choices from PlayerChoices so menu updates automatically when choices change
        choices.displayChoices();
        int selection = scr.nextInt();
        
        if (selection == 1) return "rock";
        if (selection == 2) return "paper";
        if (selection == 3) return "scissors";
        return "";
    }
}