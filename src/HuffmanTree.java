import java.util.*;

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

  public HuffmanTree(HashMap<Byte, Integer> frequencies) {
    buildFromFrequencies(frequencies);
  }

  private ArrayList<Byte> sortFrequencies(HashMap<Byte, Integer> frequencies) {
    // Creating ArrayLists of Values and Keys
    ArrayList<Byte> keys = new ArrayList<>(frequencies.keySet());
    // Sorting keys by value
    keys.sort(Comparator.comparing(x -> frequencies.get(x)));
    return keys;
  }

  private void buildFromFrequencies(HashMap<Byte, Integer> frequencies) {
    // Creating ArrayLists of sorted Keys
    ArrayList<Byte> keys = sortFrequencies(frequencies);
    ArrayList<HuffmanNode> nodes = new ArrayList<>();
    // Creating Leaf Nodes from Keys
    for (Byte key : keys) {
      nodes.add(new HuffmanLeafNode(key, frequencies.get(key)));
    }
    HuffmanInternalNode tempIntNode;
    while (nodes.size() != 1) {
      HuffmanNode leftNode = nodes.get(0);
      HuffmanNode rightNode = nodes.get(1);
      // Creating internal node from two "lightest" nodes
      tempIntNode =
        new HuffmanInternalNode(leftNode.weight() + rightNode.weight(),
          leftNode, rightNode);
      root = tempIntNode;
      nodes.remove(0);
      nodes.remove(0);
      nodes.add(tempIntNode);
      nodes.sort(Comparator.comparing(HuffmanNode::weight));
    }
    for (int i = 0; i < 1; i++) {
      System.out.println();
    }
  }

  public HuffmanNode root() {
    return root();
  }

  public int weight() {
    return root.weight();
  }

  private String findHelper(byte key, HuffmanNode node) {
    // Base Case is Leaf
    if (node instanceof HuffmanLeafNode) {
      if (((HuffmanLeafNode) node).value() == key) {
        return "";
      } else {
        return "null";
      }
    } else {
      HuffmanInternalNode tempNode = (HuffmanInternalNode) node;
      if (tempNode.left() != null) {
        if (!findHelper(key, tempNode.left()).equals(
          "null")) {
          return "0" + findHelper(key, tempNode.left());
        }
      }
      if (tempNode.right() != null) {
        if (!findHelper(key,
          tempNode.right()).equals("null")) {
          return "1" + findHelper(key, tempNode.right());
        }
      }
      return "null";
    }
  }


  public String findEncoding(byte key) {
    return findHelper(key, root);
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

