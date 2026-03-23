import java.util.*;

public class MachineLearningAlgorithm implements ComputerAlgorithm {
    private HashMap<String, Integer> frequencies;
    private LinkedList<String> history;
    private HashMap<String, String[]> choices;
    private int N = 5;

    private TCDataStore datastore;

    public MachineLearningAlgorithm(HashMap<String, String[]> choices) {
        this.choices = choices;
        this.datastore = new TCDataStore();
        this.frequencies = datastore.load();
        this.history = new LinkedList<>();
    }

    @Override
    public String getChoice() {

        if (history.size() < N - 1) return randomChoice();

        String lastSeq = String.join("", history.subList(0, N - 1));

        int max = -1;
        String predicted = null;

        for (String seq : frequencies.keySet()) {
            if (seq.startsWith(lastSeq)) {
                int freq = frequencies.get(seq);
                if (freq > max) {
                    max = freq;
                    //last move in sequence = opponent move
                    predicted = seq.substring(seq.length() - 1);
                }
            }
        }
        if (predicted == null) return randomChoice();

        for (String move : choices.keySet()) {
            if (choices.get(move)[0].equals(predicted)) {
                return move;
            }
        }

        return randomChoice();
    }

    private String randomChoice() {
        List<String> keys = new ArrayList<>(choices.keySet());
        return keys.get(new Random().nextInt(keys.size()));
    }

    @Override
    public void recordRound(String myChoice, String opponentChoice) {
        history.add(myChoice);
        history.add(opponentChoice);

        if (history.size() > N) {
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
