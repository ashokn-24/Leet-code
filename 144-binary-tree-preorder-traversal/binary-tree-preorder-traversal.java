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
  void preorder(TreeNode node, List<Integer> res) {
    if (node == null) {
      return;
    }

    res.add(node.val);
    if (node.left != null)
      preorder(node.left, res);
    if (node.right != null)
      preorder(node.right, res);
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    preorder(root, res);

    return res;
  }
}