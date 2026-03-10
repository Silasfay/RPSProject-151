import java.util.ArrayList;
import java.util.Scanner;
public class GameSetUp {
    private Scanner scr;
    PlayerFactory factory;
    

    public GameSetUp(Scanner scan){
        this.scr = scan;
        factory = new PlayerFactory();
    }
    /* 
    public int setPlayerCount(){
        System.out.println("Enter Player Count: ");
        return scr.nextInt();
    }
    public int getGameType(){
        System.out.println("What Type of Game: ");
        return scr.nextInt();
    }
    */
    public String setPlayerName(){
        System.err.println("Enter Player Name:");
        return scr.nextLine();
    }

    public String setPlayerType(){

        System.out.println("Enter Player Type: ");
        return scr.nextLine().trim();
    }
    public ArrayList buildPlayers(int num){
        ArrayList<PlayerObject> playerList = new ArrayList();
        for(int i = 0; i < num; i ++){
            factory.createPlayer(setPlayerName(), setPlayerType());
        }
        return playerList;
    }
}
