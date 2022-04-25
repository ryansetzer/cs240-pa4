import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * JMZip Class for CS240 PA 4
 *
 * @author RYAN SETZER
 * @version 1.0
 */
public class JMZip {

  public static void main(String[] args) {
    // Checks if args are given
    if (args.length == 0) {
      System.out.println("Missing arguments, fuckass");
      return;
    }
    try { // Tries to open and read file
      File file = new File(args[0]);
      FileInputStream fis = new FileInputStream(file);
      System.out.println(fis.read());
    } catch (Exception e) { // If file fails to be opened or read
      e.printStackTrace();
    }
  }
}
