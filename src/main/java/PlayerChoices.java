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

    public String determineChoice(int selection) {
        // Goes through available options to select the option matching the index of the HashMap
        // If no choice match a selected number, return null and ask for correct selection
        int i = 1;
        for(String choice : beats.keySet()){
            if(i == selection) {
                return choice;
            }
            i++;
        }

        return null;
    }

    public boolean determineWhoBeatsWho(String choice, String opponent) {
        // Check if choice is equal, skips for loop
        if (choice.equals(opponent)) {
            return false;
        }

        // Gets possible choices that current choice beats
        // If opponent's choice match any choices that current choice beats, then the current perspective wins
        String[] possibleWins = beats.get(choice);
        for (String possibleWin : possibleWins) {
            if (possibleWin.equals(opponent)) {
                return true;
            }
        }
        return false;
    }
}