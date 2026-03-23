import java.util.*;
public class RandomAlgorithm implements ComputerAlgorithm {
    private Random ran;
    private HashMap<String, String[]> choices;

    public RandomAlgorithm(HashMap<String, String[]> choices) {
        this.ran = new Random();
        this.choices = choices;
    }
    @Override
    public String getChoice() {
        List<String> keys = new ArrayList<>(choices.keySet());
        return keys.get(ran.nextInt(keys.size()));
    }

    @Override
    public void recordRound(String opponentChoice) {
        // do nothing
    }

    @Override
    public void saveData() {
        // do nothing
    }
}
