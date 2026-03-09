import java.util.Scanner;
public class HumanLogic implements PlayerLogic {
    private Scanner scr;
    
    public HumanLogic(Scanner scan){
        this.scr = scan;
    }

    @Override
    public String getChoice(){
        return scr.nextLine().trim();
    }
}
