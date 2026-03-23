public interface PlayerLogic {
    String getChoice();

    //do nothing
    default void recordRound(String myChoice, String opponentChoice) {}
    default void saveData() {}
}
