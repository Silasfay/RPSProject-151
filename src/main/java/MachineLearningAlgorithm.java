import java.util.*;

public class MachineLearningAlgorithm implements ComputerAlgorithm {
    private HashMap<String, Integer> frequencies;
    private LinkedList<String> history;
    private HashMap<String, String[]> choices;
    private int N = 5;
    private String lastPrediction = null;
    private TCDataStore datastore;

    public MachineLearningAlgorithm(HashMap<String, String[]> choices) {
        this.choices = choices;
        this.datastore = new TCDataStore();
        this.frequencies = datastore.load();
        this.history = new LinkedList<>();
    }

    @Override
    public String getChoice() {
        if (history.size() < N - 1){
            lastPrediction = null;
            return randomChoice();
        }

        // take last N-1 entries to build lookup sequence
        String lastSeq = String.join("", history.subList(history.size() - (N - 1), history.size()));

        int max = -1;
        String predicted = null;

        for (String seq : frequencies.keySet()) {
            if (seq.startsWith(lastSeq)) {
                int freq = frequencies.get(seq);
                if (freq > max) {
                    max = freq;
                    // last character is the predicted human choice
                    predicted = seq.substring(seq.length() - 1);
                }
            }
        }

        // store prediction for display
        lastPrediction = predicted;

        if (predicted == null) return randomChoice();

        // find move that beats predicted human choice
        for (String move : choices.keySet()) {
            if (choices.get(move)[0].startsWith(predicted)) {
                return move;
            }
        }
        return randomChoice();
    }

    public String getLastPrediction(){
        if(lastPrediction == null) return "Not enough data";
        switch(lastPrediction){
            case "r": return "rock";
            case "p": return "paper";
            case "s": return "scissors";
            default: return lastPrediction;
        }
    }

    private String randomChoice() {
        List<String> keys = new ArrayList<>(choices.keySet());
        return keys.get(new Random().nextInt(keys.size()));
    }
    @Override
    public void recordRound(String myChoice, String opponentChoice) {

        history.add(String.valueOf(opponentChoice.charAt(0)));

        while(history.size() > N) {
            history.removeFirst();
        }

        if (history.size() == N) {
            String seq = String.join("", history);
            frequencies.put(seq, frequencies.getOrDefault(seq, 0) + 1);
        }
    }

    @Override
    public void saveData() {
        datastore.save(frequencies);
    }
}