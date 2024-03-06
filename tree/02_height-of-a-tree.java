/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public int maxDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }

    // we can return 0 here if want to get height on the basis of edges
    // in above case root == null {reuturn -1}
    if (root.left == null && root.right == null) {
      return 1;
    }

    int left_subtree_height = maxDepth(root.left);
    int right_subtree_height = maxDepth(root.right);

    return 1 + Math.max(left_subtree_height, right_subtree_height);

  }
}