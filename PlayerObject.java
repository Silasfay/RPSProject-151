public class PlayerObject {
    private String name;
    private PlayerLogic playerLogic;
    private String currentChoice;

    public PlayerObject(String name, PlayerLogic playerLogic){
        this.name = name;
        this.playerLogic = playerLogic;
    }

    public String makeSelection(){
        currentChoice = playerLogic.getChoice();
        return currentChoice;
    }

    public String getCurrentChoice(){
        return currentChoice;
    }

    public String getName(){
        return name;
    }

    public PlayerLogic getLogic(){
        return playerLogic;
    }
}
