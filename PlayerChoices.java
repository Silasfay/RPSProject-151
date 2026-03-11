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

    // displays choices dynamically from the HashMap so adding new choices updates menu automatically
    public void displayChoices(){
        System.out.println("Make your choice:");
        System.out.println("_______________");
        int i = 1;
        for(String choice : beats.keySet()){
            System.out.println(i + ") " + choice);
            i++;
        }
        System.out.println("_______________");
    }
}