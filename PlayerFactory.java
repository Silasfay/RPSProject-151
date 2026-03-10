import java.util.Scanner;

public class PlayerFactory {
    private Scanner scr;

    public enum PlayerType {
        HUMAN, COMPUTER
    }

    public PlayerFactory(Scanner scan){
        this.scr = scan;
    }

    public PlayerObject createPlayer(String name, PlayerType type){
        PlayerLogic logic;

        switch(type){
            case HUMAN:
                logic = new HumanLogic(scr);
                break;
            case COMPUTER:
                logic = new ComputerLogic();
                break;
            default:
                throw new IllegalArgumentException("Unknown player type: " + type);
        }

        return new PlayerObject(name, logic);
    }
}