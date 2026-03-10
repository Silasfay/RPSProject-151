import java.util.Scanner;

public class PlayerFactory {
    private Scanner scr;
    private PlayerChoices choices;

    public PlayerFactory(Scanner scan, PlayerChoices choices){
        this.scr = scan;
        this.choices = choices;
    }

    public PlayerObject createPlayer(String name, PlayerLogic logic){
        return new PlayerObject(name, logic);
    }
}