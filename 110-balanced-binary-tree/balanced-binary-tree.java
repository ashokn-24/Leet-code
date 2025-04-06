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

    int lft = 1 + dfs(node.left);
    int rht = 1 + dfs(node.right);

    return Math.max(lft, rht);
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    int left = dfs(root.left);
    int right = dfs(root.right);

    if (Math.abs(left - right) > 1)
      return false;

    boolean lh = isBalanced(root.left);
    boolean rh = isBalanced(root.right);

    if(!lh || !rh){
      return false;
    }

    return true;
  }
}