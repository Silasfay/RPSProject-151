public interface ComputerAlgorithm {
    String getChoice();
    void recordRound(String myChoice, String opponentChoice);
    void saveData();
}
