import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashMap;

public class RPSTest {

    // PlayerChoices Tests

    @Test
    public void testRockBeatsScissors(){
        PlayerChoices choices = new PlayerChoices();
        assertTrue(choices.determineWhoBeatsWho("rock", "scissors"));
    }

    @Test
    public void testPaperBeatsRock(){
        PlayerChoices choices = new PlayerChoices();
        assertTrue(choices.determineWhoBeatsWho("paper", "rock"));
    }

    @Test
    public void testScissorsBeatsPaper(){
        PlayerChoices choices = new PlayerChoices();
        assertTrue(choices.determineWhoBeatsWho("scissors", "paper"));
    }

    @Test
    public void testRockDoesNotBeatPaper(){
        PlayerChoices choices = new PlayerChoices();
        assertFalse(choices.determineWhoBeatsWho("rock", "paper"));
    }

    @Test
    public void testTieReturnsFalse(){
        PlayerChoices choices = new PlayerChoices();
        assertFalse(choices.determineWhoBeatsWho("rock", "rock"));
    }

    @Test
    public void testGetChoicesReturnsThree(){
        PlayerChoices choices = new PlayerChoices();
        assertEquals(3, choices.getChoices().size());
    }

    @Test
    public void testDetermineChoiceValidIndex(){
        PlayerChoices choices = new PlayerChoices();
        assertNotNull(choices.determineChoice(1));
    }

    @Test
    public void testDetermineChoiceInvalidIndex(){
        PlayerChoices choices = new PlayerChoices();
        assertNull(choices.determineChoice(99));
    }

    // GameResult Tests

    @Test
    public void testPlayer1WinsRock(){
        PlayerChoices choices = new PlayerChoices();
        GameResult result = new GameResult();
        result.updateScore("rock", "scissors", choices);
        assertEquals(1, result.getPlayer1Wins());
        assertEquals(0, result.getPlayer2Wins());
    }

    @Test
    public void testPlayer2WinsRock(){
        PlayerChoices choices = new PlayerChoices();
        GameResult result = new GameResult();
        result.updateScore("scissors", "rock", choices);
        assertEquals(0, result.getPlayer1Wins());
        assertEquals(1, result.getPlayer2Wins());
    }

    @Test
    public void testTieNoScoreChange(){
        PlayerChoices choices = new PlayerChoices();
        GameResult result = new GameResult();
        result.updateScore("rock", "rock", choices);
        assertEquals(0, result.getPlayer1Wins());
        assertEquals(0, result.getPlayer2Wins());
    }

    @Test
    public void testPlayer1WinsPaper(){
        PlayerChoices choices = new PlayerChoices();
        GameResult result = new GameResult();
        result.updateScore("paper", "rock", choices);
        assertEquals(1, result.getPlayer1Wins());
    }

    @Test
    public void testPlayer1WinsScissors(){
        PlayerChoices choices = new PlayerChoices();
        GameResult result = new GameResult();
        result.updateScore("scissors", "paper", choices);
        assertEquals(1, result.getPlayer1Wins());
    }

    @Test
    public void testScoreAccumulatesOverRounds(){
        PlayerChoices choices = new PlayerChoices();
        GameResult result = new GameResult();
        result.updateScore("rock", "scissors", choices);
        result.updateScore("rock", "scissors", choices);
        assertEquals(2, result.getPlayer1Wins());
    }

    @Test
    public void testCalculateWinnerPlayer1(){
        PlayerChoices choices = new PlayerChoices();
        GameResult result = new GameResult();
        result.updateScore("rock", "scissors", choices);
        assertTrue(result.calculateWinner() > 0);
    }

    @Test
    public void testCalculateWinnerDraw(){
        PlayerChoices choices = new PlayerChoices();
        GameResult result = new GameResult();
        result.updateScore("rock", "scissors", choices);
        result.updateScore("scissors", "rock", choices);
        assertEquals(0, result.calculateWinner());
    }

    // RandomAlgorithm Tests

    @Test
    public void testRandomAlgorithmReturnsValidChoice(){
        PlayerChoices choices = new PlayerChoices();
        RandomAlgorithm random = new RandomAlgorithm(choices.getChoices());
        String choice = random.getChoice();
        assertTrue(choices.getChoices().containsKey(choice));
    }

    @Test
    public void testRandomAlgorithmNeverReturnsNull(){
        PlayerChoices choices = new PlayerChoices();
        RandomAlgorithm random = new RandomAlgorithm(choices.getChoices());
        assertNotNull(random.getChoice());
    }

    @Test
    public void testRandomAlgorithmPicksAllChoicesOverTime(){
        PlayerChoices choices = new PlayerChoices();
        RandomAlgorithm random = new RandomAlgorithm(choices.getChoices());
        boolean sawRock = false;
        boolean sawPaper = false;
        boolean sawScissors = false;

        for(int i = 0; i < 100; i++){
            String choice = random.getChoice();
            if(choice.equals("rock")) sawRock = true;
            if(choice.equals("paper")) sawPaper = true;
            if(choice.equals("scissors")) sawScissors = true;
        }

        assertTrue(sawRock);
        assertTrue(sawPaper);
        assertTrue(sawScissors);
    }

    // ComputerLogic Tests 

    @Test
    public void testComputerLogicReturnsValidChoice(){
        PlayerChoices choices = new PlayerChoices();
        ComputerLogic cpu = new ComputerLogic(new RandomAlgorithm(choices.getChoices()));
        String choice = cpu.getChoice();
        assertTrue(choices.getChoices().containsKey(choice));
    }

    @Test
    public void testComputerLogicNeverReturnsNull(){
        PlayerChoices choices = new PlayerChoices();
        ComputerLogic cpu = new ComputerLogic(new RandomAlgorithm(choices.getChoices()));
        assertNotNull(cpu.getChoice());
    }

    // PlayerObject Tests

    @Test
    public void testPlayerObjectGetName(){
        PlayerChoices choices = new PlayerChoices();
        PlayerObject player = new PlayerObject("Silas", new ComputerLogic(new RandomAlgorithm(choices.getChoices())));
        assertEquals("Silas", player.getName());
    }

    @Test
    public void testPlayerObjectMakeSelectionNotNull(){
        PlayerChoices choices = new PlayerChoices();
        PlayerObject player = new PlayerObject("CPU", new ComputerLogic(new RandomAlgorithm(choices.getChoices())));
        assertNotNull(player.makeSelection());
    }

    @Test
    public void testPlayerObjectMakeSelectionValidChoice(){
        PlayerChoices choices = new PlayerChoices();
        PlayerObject player = new PlayerObject("CPU", new ComputerLogic(new RandomAlgorithm(choices.getChoices())));
        String choice = player.makeSelection();
        assertTrue(choices.getChoices().containsKey(choice));
    }

    @Test
    public void testPlayerObjectGetCurrentChoice(){
        PlayerChoices choices = new PlayerChoices();
        PlayerObject player = new PlayerObject("CPU", new ComputerLogic(new RandomAlgorithm(choices.getChoices())));
        player.makeSelection();
        assertNotNull(player.getCurrentChoice());
    }

    // MachineLearningAlgorithm Tests

    @Test
    public void testMLAlgorithmReturnsValidChoice(){
        PlayerChoices choices = new PlayerChoices();
        MachineLearningAlgorithm ml = new MachineLearningAlgorithm(choices.getChoices());
        String choice = ml.getChoice();
        assertTrue(choices.getChoices().containsKey(choice));
    }

    @Test
    public void testMLAlgorithmNeverReturnsNull(){
        PlayerChoices choices = new PlayerChoices();
        MachineLearningAlgorithm ml = new MachineLearningAlgorithm(choices.getChoices());
        assertNotNull(ml.getChoice());
    }

    @Test
    public void testMLAlgorithmRecordRoundDoesNotCrash(){
        PlayerChoices choices = new PlayerChoices();
        MachineLearningAlgorithm ml = new MachineLearningAlgorithm(choices.getChoices());
        ml.recordRound("rock", "scissors");
        ml.recordRound("paper", "rock");
        assertNotNull(ml.getChoice());
    }

    @Test
    public void testMLAlgorithmReturnsValidChoiceAfterHistory(){
        PlayerChoices choices = new PlayerChoices();
        MachineLearningAlgorithm ml = new MachineLearningAlgorithm(choices.getChoices());
        // build up enough history to trigger prediction
        for(int i = 0; i < 10; i++){
            ml.recordRound("rock", "scissors");
        }
        String choice = ml.getChoice();
        assertTrue(choices.getChoices().containsKey(choice));
    }
}