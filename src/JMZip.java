import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
      HashMap<Byte, Integer> frequencies = new HashMap<>();
      byte[] fileAsBytes = new byte[(int) readFile.length()];
      fis.read(fileAsBytes);
      fis.close();
      // Temporary variable to store frequency of byte
      int frequency;
      // Iterating over all bytes to store in Frequencies
      for (int i = 0; i < fileAsBytes.length; i++) {
        // Gathering frequency of byte
        frequency = frequencies.getOrDefault(fileAsBytes[i], 0);
        // Incrementing frequency when found
        frequencies.put(fileAsBytes[i], frequency + 1);
      }
      HuffmanTree huffmantree = new HuffmanTree(frequencies);



    } catch (Exception e) { // If file fails to be opened or read
      e.printStackTrace();
    }
  }
}
