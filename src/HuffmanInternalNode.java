/**
 * Huffman Internal Node for CS240 PA-4.
 *
 * @author RYAN SETZER & OpenDSA
 * @version 1.0
 */
public class HuffmanInternalNode extends HuffmanNode {
  private int weight;
  private HuffmanNode left;
  private HuffmanNode right;

  /**
   * Huffman Internal Node Constructor.
   *
   * @param weight - weight of node.
   * @param left   - left node of root.
   * @param right  - right node of root.
   */
  public HuffmanInternalNode(int weight, HuffmanNode left, HuffmanNode right) {
    this.weight = weight;
    this.left = left;
    this.right = right;
  }

  public HuffmanNode left() {
    return left;
  }

  public HuffmanNode right() {
    return right;
  }

  public int weight() {
    return weight;
  }

  public boolean isLeaf() {
    return false;
  }
}
