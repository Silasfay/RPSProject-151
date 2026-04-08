import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import java.util.Optional;

public class RPSController {

    @FXML private Label roundLabel;
    @FXML private Label humanChoiceLabel;
    @FXML private Label predictedLabel;
    @FXML private Label computerChoiceLabel;
    @FXML private Label winnerLabel;
    @FXML private Label humanWinsLabel;
    @FXML private Label computerWinsLabel;
    @FXML private Label tiesLabel;

    private GameManager gameManager;
    private int totalRounds = 20; // default

    // called automatically when FXML loads
    public void initialize(){
        startNewGame();
    }

    private void startNewGame(){
        gameManager = new GameManager(totalRounds);
        roundLabel.setText("Round: 0 / " + totalRounds);
        humanChoiceLabel.setText("Human Chooses: ");
        predictedLabel.setText("Predicted Human Choice: ");
        computerChoiceLabel.setText("Computer Chooses: ");
        winnerLabel.setText("Winner: ");
        humanWinsLabel.setText("Human Wins: 0");
        computerWinsLabel.setText("Computer Wins: 0");
        tiesLabel.setText("Ties: 0");
    }

    @FXML
    public void onRock(){ playRound("rock"); }

    @FXML
    public void onPaper(){ playRound("paper"); }

    @FXML
    public void onScissors(){ playRound("scissors"); }

    private void playRound(String humanChoice){
        if(gameManager.isMatchOver()){
            showAlert("Game Over", "Start a new game from the Game menu!");
            return;
        }

        // play the round and get results back
        GameManager.RoundResult result = gameManager.playRound(humanChoice);

        // update all labels with full text
        humanChoiceLabel.setText("Human Chooses: " + result.humanChoice);
        predictedLabel.setText("Predicted Human Choice: " + result.predictedChoice);
        computerChoiceLabel.setText("Computer Chooses: " + result.computerChoice);
        winnerLabel.setText("Winner: " + result.winner);
        humanWinsLabel.setText("Human Wins: " + result.humanWins);
        computerWinsLabel.setText("Computer Wins: " + result.computerWins);
        tiesLabel.setText("Ties: " + result.ties);
        roundLabel.setText("Round: " + gameManager.getCurrentRound() + " / " + totalRounds);

        if(gameManager.isMatchOver()){
            showAlert("Game Over!", "Final Result: " + result.overallWinner);
            gameManager.saveData();
        }
    }

    @FXML
    public void onNewGame(){
        TextInputDialog dialog = new TextInputDialog("20");
        dialog.setTitle("New Game");
        dialog.setHeaderText("Start a new game");
        dialog.setContentText("Enter number of rounds:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(rounds -> {
            try {
                totalRounds = Integer.parseInt(rounds);
            } catch(NumberFormatException e){
                totalRounds = 20;
            }
            startNewGame();
        });
    }

    @FXML
    public void onExit(){
        gameManager.saveData();
        System.exit(0);
    }

    @FXML
    public void onAbout(){
        showAlert("About", 
            "Rock Paper Scissors\nCS 151 - Object Oriented Design\nSan Jose State University");
    }

    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}