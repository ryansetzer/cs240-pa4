public class HuffmanLeafNode extends HuffmanNode{
  private byte element;
  private int weight;

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
