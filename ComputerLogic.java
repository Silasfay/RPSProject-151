import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ComputerLogic implements PlayerLogic {
    private Random ran;
    private HashMap<String, String[]> choice;

    private boolean isTC;
    private HashMap<String, Integer> frequencies;
    private LinkedList<String> history;
    private int N = 5;

    private TCDataStore datastore;
    
    public ComputerLogic(HashMap<String, String[]> choices) {
        this(choices, false);
    }

    public ComputerLogic(HashMap<String, String[]> choices){
        this.ran = new Random();
        this.choice = choices;
        this.isTC = isTC;

        if(isTC){
            dataStore = new TCDataStore();
            frequencies = dataStore.load(); //load saved data
            history = new LinkedList<>();
        }
    }

    @Override
    public String getChoice(){
        if (!isML) return randomChoice();

        if (history.size() < N - 1) return randomChoice();

        String lastSeq = String.join("", history);

        int max = -1;
        String predictedHuman = null;

        for (String seq : frequencies.keySet()) {
            if (seq.startsWith(lastSeq)) {
                int freq = frequencies.get(seq);
                if (freq > max) {
                    max = freq;
                    predictedHuman = seq.substring(seq.length() - 1);
                }
            }
        }
        if(predictedHuman == null) return randomChoice();

        for(String move : choices.keySet()){
            if(choices.get(move)[0].equals(predictedHuman)){
                return move;
            }
        }
        return randomChoice();
    }

    private String randomChoice() {
        List<String> keys = new ArrayList<>(choices.keySet());
        return keys.get(ran.nextInt(keys.size()));
    }

    public void recordRound(String humanChoice){
        if(!isTC) return;

        history.add(humanChoice);
        if(history.size() > N){
            history.removeFirst();
        }

        if history.size() == N{
            String seq = String.join("", history);
            frequencies.put(seq, frequencies.getORDefault(seq, 0) + 1);
        }
    }
    
    public void saveData() {
        if (!isTC) return;
        dataStore.save(frequencies);
    }
    
}
