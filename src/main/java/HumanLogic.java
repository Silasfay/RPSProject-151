public class HumanLogic implements PlayerLogic {
    private PlayerChoices choices;
    private String pendingChoice = null;

    public HumanLogic(PlayerChoices choices){
        this.choices = choices;
    }

    // called by controller when button clicked
    public void setChoice(String choice){
        this.pendingChoice = choice;
    }

    @Override
    public String getChoice(){
        return pendingChoice;
    }

    @Override
    public void recordRound(String myChoice, String opponentChoice){}

    @Override
    public void saveData(){}
}