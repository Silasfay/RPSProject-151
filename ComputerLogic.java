import java.util.*;

public class ComputerLogic implements PlayerLogic {
    private ComputerAlgorithm algorithm;

    public ComputerLogic(ComputerAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String getChoice() {
        return algorithm.getChoice();
    }

    public void recordRound(String opponentChoice) {
        algorithm.recordRound(opponentChoice);
    }

    public void saveData() {
        algorithm.saveData();
    }
    
}
