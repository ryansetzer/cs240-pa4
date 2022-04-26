import java.io.*;
import java.util.HashMap;

/**
 * JMZip Class for CS240 PA 4
 *
 * @author RYAN SETZER
 * @version 1.0
 */
public class JMZip {

  public static void main(String[] args) {
    // Checks if args are given
    if (args.length <= 0 || args.length > 2) {
      System.out.println("falsch Argumente, fickenarsch");
      return;
    }
    try { // Tries to open and read file
      File readFile = new File(args[0]);
      FileWriter writeFile = new FileWriter(args[1]);
      FileInputStream fis = new FileInputStream(readFile);
      // Hash Map of Character Frequencies
      HashMap<Byte, Integer> frequencies = new HashMap<>();
      // Temporary Character used for While Loop
      int character;
      // While characters still exist in file
      while ((character = fis.read()) != -1) {
        // Finds frequency of character in map
        int frequency = frequencies.getOrDefault(character, 0);
        // Increments character count
        frequencies.put((byte) character, frequency + 1);
      }

    } catch (Exception e) { // If file fails to be opened or read
      e.printStackTrace();
    }
  }
}
