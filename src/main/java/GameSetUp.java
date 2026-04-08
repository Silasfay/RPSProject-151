import java.util.ArrayList;

public class GameSetUp {
    private PlayerFactory factory;
    private PlayerChoices choices;

    public GameSetUp(PlayerChoices choices){
        this.choices = choices;
        this.factory = new PlayerFactory(choices);
    }

    public ArrayList<PlayerObject> buildPlayers(){
        ArrayList<PlayerObject> playerList = new ArrayList<>();
        // human player
        playerList.add(factory.createPlayer("Human", "H"));
        // ML computer by default
        playerList.add(factory.createPlayer("Computer", "TC"));
        return playerList;
    }
}