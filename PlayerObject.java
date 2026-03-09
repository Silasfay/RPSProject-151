public class PlayerObject implements PlayerObjectTemplate {
    private String name;
    private PlayerLogic playerLogic;
    private String currentChoice;

    public String makeSelection() {
        playerLogic.getChoice(this);
        return currentChoice;
    }
}
