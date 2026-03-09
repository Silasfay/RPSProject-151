public class PlayerObject {
    private String name;
    private PlayerLogic playerLogic;
    private String currentChoice;

    public PlayerObject(){
        playerLogic = new PlayerLogic();
    }
    
    public String makeSelection() {
        playerLogic.getChoice(this);
        return currentChoice;
    }
    public String getName(){
        return this.name;
    }
}
