public class ComputerLogic implements PlayerLogic {
    private ComputerAlgorithm algorithm;

    public ComputerLogic(ComputerAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public ComputerAlgorithm getAlgorithm(){
    return algorithm;
}
    @Override
    public String getChoice() {
        return algorithm.getChoice();
    }

    public void recordRound(String myChoice, String opponentChoice) {
        algorithm.recordRound(myChoice, opponentChoice);
    }

    public void saveData() {
        algorithm.saveData();
    }
    
}
