import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;

/**
 * JMUnzip Class for CS240 PA 4.
 *
 * @author RYAN SETZER
 * @version 1.0
 */
public class JMUnzip {

  public static void main(String[] args) {
    // Checks if args are given
    if (args.length <= 0 || args.length > 2 || !args[0].endsWith(".jmz")) {
      System.out.println("falsch Argumente, fickenarsch");
      return;
    }
    try { // Tries to open and read file
      File readFile = new File(args[0]);
      FileWriter writeFile = new FileWriter(args[1]);
      FileInputStream fis = new FileInputStream(readFile);
    } catch (Exception e) { // If file fails to be opened or read
      e.printStackTrace();
    }
  }
}
