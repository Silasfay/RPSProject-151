
public class InputValidator {
    public static boolean isValidChoice(String input, PlayerChoices playerChoices) {
        return playerChoices.getChoices().containsKey(input);
    }
}
