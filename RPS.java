

public class RPS {
    public static void main(String[] args) {
        System.out.println("Welcome to blehhh Rock Paper Scisors Game!");

        //comand line prompts
        String computerMode = "PROMPT"; //default bahavior

        for(String arg : args){
            if(arg.equalsIgnoreCase("-r")){
                mode = "RANDOM";
            }
            else if(arg.equalsIgnoreCase("-m")){
                mode = "TC";
            }
        }
        
        GameManager manager = new GameManager();
        manager.start();
    }
}
