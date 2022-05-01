import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

/**
 * JMUnzip Class for CS240 PA 4.
 *
 * @author RYAN SETZER
 * @version 1.0
 */
public class JMUnzip {

  private static void decode(String[] args) {
    try {
      // Read-File
      FileInputStream fis = new FileInputStream(args[0]);
      ObjectInputStream ois = new ObjectInputStream(fis);
      HuffmanSave huffmansave = (HuffmanSave) ois.readObject();
      ois.close();
      // Write-File
      File writeFile = new File(args[1]);
      writeFile.createNewFile();
      FileOutputStream fos = new FileOutputStream(writeFile);


      // Getting Objects from HuffmanSave
      BitSequence bitSequence = huffmansave.getEncoding();
      // I do not know why I need to add this space but when I remove it, the
      // whole program dies
      String sequenceString = bitSequence.toString() + " ";
      HashMap<Byte, Integer> frequencies = huffmansave.getFrequencies();
      HuffmanTree huffmantree = new HuffmanTree(frequencies);
      // Mapping Bytes with their Encodings
      HashMap<String, Byte> encodingsWithKeys = new HashMap<>();
      for (Byte key : frequencies.keySet()) {
        encodingsWithKeys.put(huffmantree.findEncoding(key), key);
      }
      String[] encodings = encodingsWithKeys.keySet()
        .toArray(new String[encodingsWithKeys.size()]);
      for (int i = 0; i < sequenceString.length(); i++) {
        for (int j = 0; j < encodings.length; j++) {
          if (sequenceString.substring(0, i).equals(encodings[j])) {
            fos.write(encodingsWithKeys.get(sequenceString.substring(0, i)));
            sequenceString = sequenceString.substring(i);
            i = 0;
            break;
          }
        }
      }
      // Add end of file
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Main Method for JMUnzip.
   *
   * @param args - Files for Un-Zipping.
   */
  public static void main(String[] args) {
    // Checks if args are given
    if (args.length <= 0 || args.length > 2) {
      String errorMessage = "Wrong Parameters: too ";
      errorMessage += args.length > 2 ? "many" : "few";
      System.out.println(errorMessage);
      return;
    }
    decode(args);
  }
}
