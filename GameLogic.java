import java.util.Scanner;
public class GameLogic {
    private Scanner scnr;
    private ComputerLogic computer;
    private PlayerChoices choices;
    private GameResult results;

    public GameLogic(){
        scnr = new Scanner(System.in);
        choices = new PlayerChoices();
        computer = new ComputerLogic(choices.getChoices());
        results = new GameResult(); 
    }

    public void playRound(int roundNumber) {
        System.out.println("\nRound " + roundNumber);
        System.out.println("Make your choice:");
        System.out.println("_______________");
        System.out.println("1) Rock");
        System.out.println("2) Paper");
        System.out.println("3) Scissors");
        System.out.println("_______________");

        int selection = scnr.nextInt();

        String playerChoice = "";

        if (selection == 1) playerChoice = "rock";
        if (selection == 2) playerChoice = "paper";
        if (selection == 3) playerChoice = "scissors";

        // get computer move
        String computerChoice = computer.getChoice();
        
        //current round choices
        System.out.println("Player chose: " + playerChoice);
        System.out.println("Computer chose: " + computerChoice);
        
        //Get round results
        String roundResult = results.updateScore(playerChoice, computerChoice, choices);
        System.out.println("Round Result: " + roundResult);

        // Display current score
        System.out.println("Current Score:");
        System.out.println("Player: " + results.getPlayer1Wins());
        System.out.println("Computer: " + results.getPlayer2Wins());
    }

    // Display final overall score
    public void displayFinalResults(){
        results.displayWinner();
    }
}