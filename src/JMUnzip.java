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

  private static void Decode(String[] args) {
    try {
      // Read-File
      File readFile = new File(args[0]);
    } catch (Exception e) {

    }

  }

  public static void main(String[] args) {
    // Checks if args are given
    if (args.length <= 0 || args.length > 2 || !args[0].endsWith(".jmz")) {
      System.out.println("falsch Argumente, fickenarsch");
      return;
    }
    Decode(args);
  }
}
