import java.util.Scanner;
public class GameLogic {
    private Scanner scnr;
    private ComputerLogic computer;
    private PlayerChoices choices;

    public GameLogic(){
        scnr = new Scanner(System.in);
        choices = new PlayerChoices();
        computer = new ComputerLogic(choices.getChoices());
    }

    public void runGame() {
        int count = 0;
        while (count <= 20) {
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
            String computerChoice = computer.getString();

            System.out.println("Player chose: " + playerChoice);
            System.out.println("Computer chose: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("Tie!");
            }
            else if (choices.getBeats(playerChoice)[0].equals(computerChoice)) {
                System.out.println("Player wins!");
            }
            else {
                System.out.println("Computer wins!");
            }

            count++;
        }

    }
        
}
