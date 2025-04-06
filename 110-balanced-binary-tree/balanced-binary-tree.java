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
  int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int lft = dfs(node.left);
    if (lft == -1)
      return -1;

    int rht = dfs(node.right);
    if (rht == -1)
      return -1;

    if (Math.abs(lft - rht) > 1)
      return -1;

    return 1 + Math.max(lft, rht);
  }

  public boolean isBalanced(TreeNode root) {
    return dfs(root) != -1;
  }
}