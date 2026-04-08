import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class RPSController {

    @FXML private Text roundLabel;
    @FXML private Text humanChoiceLabel;
    @FXML private Text predictedLabel;
    @FXML private Text computerChoiceLabel;
    @FXML private Text winnerLabel;
    @FXML private Text humanWinsLabel;
    @FXML private Text computerWinsLabel;
    @FXML private Text tiesLabel;

    private GameManager gameManager;
    private int totalRounds = 20; // default

    // called automatically when FXML loads
    public void initialize(){
        startNewGame();
    }

    private void startNewGame(){
        gameManager = new GameManager(totalRounds);
        updateRoundLabel();
    }

    // called when Rock button clicked
    @FXML
    public void onRock(){
        playRound("rock");
    }

    // called when Paper button clicked
    @FXML
    public void onPaper(){
        playRound("paper");
    }

    // called when Scissors button clicked
    @FXML
    public void onScissors(){
        playRound("scissors");
    }

    private void playRound(String humanChoice){
        if(gameManager.isMatchOver()){
            showAlert("Game Over", "Start a new game from the menu!");
            return;
        }

        // play the round and get results back
        GameManager.RoundResult result = gameManager.playRound(humanChoice);

        // update all labels
        humanChoiceLabel.setText("Human Chooses: " + result.humanChoice);
        predictedLabel.setText("Predicted Human Choice: " + result.predictedChoice);
        computerChoiceLabel.setText("Computer Chooses: " + result.computerChoice);
        winnerLabel.setText("Winner: " + result.winner);
        humanWinsLabel.setText("Human Wins: " + result.humanWins);
        computerWinsLabel.setText("Computer Wins: " + result.computerWins);
        tiesLabel.setText("Ties: " + result.ties);
        updateRoundLabel();

        if(gameManager.isMatchOver()){
            showAlert("Game Over", "Final winner: " + result.overallWinner);
            gameManager.saveData();
        }
    }

    private void updateRoundLabel(){
        roundLabel.setText("Round: " + gameManager.getCurrentRound() + " / " + totalRounds);
    }

    // menu handlers
    @FXML
    public void onNewGame(){
        // ask for number of rounds
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
        showAlert("About", "Rock Paper Scissors\nCS 151 - Object Oriented Design\nSan Jose State University");
    }

    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}