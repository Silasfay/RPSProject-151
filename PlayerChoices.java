import java.util.HashMap; 

public class PlayerChoices {
    private HashMap<String, String[]> beats;

    public PlayerChoices() {
        beats = new HashMap<>();
        beats.put("rock", new String[]{"scissors"});
        beats.put("paper", new String[]{"rock"});
        beats.put("scissors", new String[]{"paper"});
    }

    public HashMap<String, String[]> getChoices() {
        return beats;
    }

    public String[] getBeats(String choice) {
        return beats.get(choice);
    }
}
