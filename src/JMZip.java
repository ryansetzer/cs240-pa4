import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * JMZip Class for CS240 PA-4.
 *
 * @author RYAN SETZER
 * @version 1.0
 */
public class JMZip {

  private static void encode(String[] args) {
    try { // Tries to open and read-file
      // Read-File
      File readFile = new File(args[0]);
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
      BitSequence bitsequence = new BitSequence();
      for (Byte b : fileAsBytes) {
        bitsequence.appendBits(huffmantree.findEncoding(b));
      }
      HuffmanSave huffmansave = new HuffmanSave(bitsequence, frequencies);
      // Write-File
      File writeFile = new File(args[1]);
      writeFile.createNewFile();
      FileOutputStream fos = new FileOutputStream(args[1]);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(huffmansave);
      fos.close();
      oos.close();
    } catch (Exception e) { // If file fails to be opened or read
      e.printStackTrace();
    }
  }

  /**
   * Main Method for JMZip.
   *
   * @param args - Files for Zipping.
   */
  public static void main(String[] args) {
    // Checks if args are given
    if (args.length <= 0 || args.length > 2) {
      String errorMessage = "Wrong Parameters: too ";
      errorMessage += args.length > 2 ? "many" : "few";
      System.out.println(errorMessage);
      return;
    }
    encode(args);
  }
}
