public class GameLogger implements Logger {
    private PrintWriter writer;

    public GameLogger(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            System.out.println("Error creating log file.");
        }
    }

    @Override
    public void log(String message) {
        if (writer != null) {
            writer.println(message);
        }
    }

    @Override
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
   
