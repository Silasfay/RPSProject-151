
public class InputValidator {
    public boolean isValidChoice(String input, PlayerChoices playerChoices) {
        return playerChoices.getChoices().containsKey(input);
    }
}
