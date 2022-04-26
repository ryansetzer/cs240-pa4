/**
 * Huffman Tree Class for CS240 PA-4
 *
 * @author RYAN SETZER
 * @version 1.0
 */
public class HuffmanTree {
  private HuffmanNode root;

  public HuffmanTree(byte element, int weight) {
    this.root = new HuffmanLeafNode(element, weight);
  }

  public HuffmanTree(int weight, HuffmanNode left, HuffmanNode right) {
    this.root = new HuffmanInternalNode(weight, left, right);
  }

  public HuffmanNode root() {
    return root();
  }

  public int weight() {
    return root.weight();
  }

  public int compareTo(Object obj) {
    HuffmanTree that = (HuffmanTree) obj;
    if (root.weight() < that.weight()) {
      return -1;
    } else if (root.weight() == that.weight()) {
      return 0;
    } else {
      return 1;
    }
  }
}

