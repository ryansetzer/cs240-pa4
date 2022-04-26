/**
 * Huffman Leaf Node Class for CS240 PA-4.
 *
 * @author RYAN SETZER & OpenDSA
 * @version 1.0
 */
public class HuffmanLeafNode extends HuffmanNode {
  private byte element;
  private int weight;

  /**
   * Huffman Leaf Node Constructor.
   *
   * @param element - element for node.
   * @param weight  - weight of node.
   */
  public HuffmanLeafNode(byte element, int weight) {
    this.element = element;
    this.weight = weight;
  }

  public byte value() {
    return element;
  }

  public int weight() {
    return weight;
  }

  public boolean isLeaf() {
    return true;
  }
}
