public class HuffmanInternalNode extends HuffmanNode{
  private int weight;
  private HuffmanNode left;
  private HuffmanNode right;

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
