import javafx.application.Application;
import javafx.fxml.FXMLLoader;  
import javafx.scene.Parent;      
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RockPaperScissors.fxml")); 
        Scene scene = new Scene(root);
        stage.setTitle("Rock Paper Scissors");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}