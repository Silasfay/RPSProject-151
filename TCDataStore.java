import java.util.*;
import java.io.*;

public class TCDataStore{
  private final String FILE_NAME = "frequencies.txt";

  public HashMap<String, Integer> load(){
    HashMap<String, Integer> data = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
      String line;

      while ((line = reader.readLine()) != null){
        String[] parts = line.split(":");
        data.put(parts[0], Integer.parseInt(parts[1]));
      }
    } catch (IOExceprion e){
      System.out.println("File Does Not Exist");
    }
    return data;
  }

  public void save(HashMap<String, Integer> data){
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
      for(String key :  data.keySet()){
        writer.println(key + ":" + data.get(key));
    } catch (IOException e){
      System.out.println("Data Saving Error");
    }
  }
}
