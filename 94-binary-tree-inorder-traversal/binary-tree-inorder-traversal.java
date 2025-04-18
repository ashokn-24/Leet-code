
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  void inorder(TreeNode node, List<Integer> res) {
    if (node == null) {
      return;
    }

    if (node.left != null)
      inorder(node.left, res);

    res.add(node.val);

    if (node.right != null)
      inorder(node.right, res);
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    inorder(root, res);

    return res;
  }
}