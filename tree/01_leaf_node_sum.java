import java.util.ArrayList;

class Solution {

  static class Node {
    public int val;
    public ArrayList<Node> children;

    Node() {
      this.val = 0;
      this.children = new ArrayList<>();
    }

    Node(int val) {
      this.val = val;
      this.children = new ArrayList<>();
    }
  }

  public static int leafNodeSum(Node rootNode) {

    // is it a leaf node ?
    if (rootNode.children.size() == 0) {
      return rootNode.val;
    }

    int sum = 0;

    for (Node child : rootNode.children) {
      sum += leafNodeSum(child);
    }

    return sum;
  }

  public static void main(String[] args) {

    Node rootNode = new Node(5);

    Node n1 = new Node(1);
    n1.children.add(new Node(2));
    n1.children.add(new Node(9));

    Node n2 = new Node(4);
    n2.children.add(n1);
    n2.children.add(new Node(-6));

    Node n3 = new Node(7);
    n3.children.add(new Node(8));

    Node n4 = new Node(3);
    n4.children.add(new Node(0));
    n4.children.add(n3);
    n4.children.add(new Node(-4));

    rootNode.children.add(n2);
    rootNode.children.add(n4);

    int sum = leafNodeSum(rootNode);
    System.out.println("Sum is: " + sum);
  }

}
