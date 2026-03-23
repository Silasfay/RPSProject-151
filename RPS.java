public class RPS {
    public static void main(String[] args) {
        System.out.println("Welcome to blehhh Rock Paper Scisors Game!");

        // Default: no override
        String computerMode = null;

        // Check for command-line argument
        if(args.length > 0){
            if(args[0].equalsIgnoreCase("-r")){
                computerMode = "RANDOM";
            } else if(args[0].equalsIgnoreCase("-m")){
                computerMode = "ML";
            } else {
                System.out.println("Unknown command-line option. Use -r for random, -m for ML.");
            }

            // Only print message if override is active
            if(computerMode != null){
                System.out.println("Using command-line mode: " + computerMode);
            }
        }
        
        GameManager manager = new GameManager(computerMode);
        manager.start();
    }
}
