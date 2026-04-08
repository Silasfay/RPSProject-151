public class PlayerFactory {
    private PlayerChoices choices;

    public PlayerFactory(PlayerChoices choices){
        this.choices = choices;
    }

    public PlayerObject createPlayer(String name, String type){
        PlayerLogic logic = buildLogic(type);
        return new PlayerObject(name, logic);
    }

    private PlayerLogic buildLogic(String type){
        if(type.equals("H")){
            return new HumanLogic(choices);
        }
        if(type.equals("TC")){
            return new ComputerLogic(new MachineLearningAlgorithm(choices.getChoices()));
        }
        return new ComputerLogic(new RandomAlgorithm(choices.getChoices()));
    }
}