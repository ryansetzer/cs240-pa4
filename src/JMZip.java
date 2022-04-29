import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;

/**
 * JMZip Class for CS240 PA 4
 *
 * @author RYAN SETZER
 * @version 1.0
 */
public class JMZip {

  private static void Encode(String[] args) {
    try { // Tries to open and read-file
      // Read-File
      File readFile = new File(args[0]);
      FileInputStream fis = new FileInputStream(readFile);
      // Write-File
      FileOutputStream writeFile = new FileOutputStream(args[1]);
      ObjectOutputStream oos = new ObjectOutputStream(writeFile);
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
      BitSequence bitsequence = new BitSequence();
      for (Byte b : fileAsBytes) {
        bitsequence.appendBits(huffmantree.findEncoding(b));
      }
      HuffmanSave huffmansave = new HuffmanSave(bitsequence, frequencies);
      oos.writeObject(huffmansave);
      writeFile.close();
      oos.close();
    } catch (Exception e) { // If file fails to be opened or read
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // Checks if args are given
    if (args.length <= 0 || args.length > 2) {
      System.out.println("falsch Argumente, fickenarsch");
      return;
    }
    Encode(args);
  }
}
