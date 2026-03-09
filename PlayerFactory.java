
import java.util.Scanner;


public class PlayerFactory {
    private Scanner scr;
    
    public PlayerFactory(Scanner scan){
        this.scr = scan;
    }
    public PlayerObject createPlayer(String name, PlayerLogic logic){
        return new PlayerObject(name, logic);
    }
}
