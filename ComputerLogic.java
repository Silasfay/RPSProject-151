import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ComputerLogic implements PlayerLogic {
    private Random ran;
    private HashMap<String, String[]> choice;

    public ComputerLogic(HashMap<String, String[]> choices){
        this.ran = new Random();
        this.choice = choices;
    }
    @Override
    public String getChoice(){
        List<String> keys = new ArrayList<>(choice.keySet());
        return keys.get(ran.nextInt(keys.size()));
    }
}
