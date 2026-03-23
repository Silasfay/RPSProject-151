public interface PlayerLogic {
    String getChoice();
    
    default void recordRound(String opponentChoice) {}
    default void saveData() {}
}
