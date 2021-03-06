import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Huffman Tree Class for CS240 PA-4.
 *
 * @author RYAN SETZER & OpenDSA
 * @version 1.0
 */
public class HuffmanTree {

  private HuffmanNode root;

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

    // Zero Byte Files
    if (nodes.size() == 0) {
      return;
    }

    // One Byte Files
    if (nodes.size() == 1) {
      HuffmanLeafNode oneByteLeaf = (HuffmanLeafNode) nodes.get(0);
      tempIntNode = new HuffmanInternalNode(oneByteLeaf.weight(), oneByteLeaf, null);
      root = tempIntNode;
      return;
    }

    while (nodes.size() != 1) {
      HuffmanNode leftNode = nodes.get(0);
      HuffmanNode rightNode = nodes.get(1);
      // Creating internal node from two "lightest" nodes
      tempIntNode = new HuffmanInternalNode(leftNode.weight()
        + rightNode.weight(), leftNode, rightNode);
      root = tempIntNode;
      nodes.remove(0);
      nodes.remove(0);
      nodes.add(tempIntNode);
      nodes.sort(Comparator.comparing(HuffmanNode::weight));
    }
  }

  public HuffmanNode root() {
    return root();
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
      if (tempNode.left() != null && !findHelper(key, tempNode.left()).equals("null")) {
        return "0" + findHelper(key, tempNode.left());
      }
      if (tempNode.right() != null && !findHelper(key, tempNode.right()).equals("null")) {
        return "1" + findHelper(key, tempNode.right());
      }
      return "null";
    }
  }

  public String findEncoding(byte key) {
    return findHelper(key, root);
  }
}

