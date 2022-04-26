/**
 * Huffman Tree Class for CS240 PA-4.
 *
 * @author RYAN SETZER & OpenDSA
 * @version 1.0
 */
public class HuffmanTree {
  private HuffmanNode root;

  /**
   * Huffman Tree Leaf Node Constructor.
   *
   * @param element - element for Leaf Node.
   * @param weight  - weight for Leaf Node.
   */
  public HuffmanTree(byte element, int weight) {
    this.root = new HuffmanLeafNode(element, weight);
  }

  /**
   * Huffman Tree Internal Node Constructor.
   *
   * @param weight - weight for Internal Node.
   * @param left   - left Node of root.
   * @param right  - right Node of root.
   */
  public HuffmanTree(int weight, HuffmanNode left, HuffmanNode right) {
    this.root = new HuffmanInternalNode(weight, left, right);
  }

  public HuffmanNode root() {
    return root();
  }

  public int weight() {
    return root.weight();
  }

  /**
   * Comparing two Huffman Trees.
   *
   * @param obj - Object comparing with Tree.
   * @return - (-1) less (0) equals (1) greater.
   */
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

