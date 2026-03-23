public interface PlayerLogic {
    String getChoice();

    //do nothing
    default void recordRound(String opponentChoice) {}
    default void saveData() {}
}
