/**
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
    public int maxPath(TreeNode root, int[] sum) {
        if (root == null) {
            return 0;
        }
        int leftSum = maxPath(root.left, sum);
        int rightSum = maxPath(root.right, sum);

        if (leftSum < 0) {
            leftSum = 0;
        }
        if (rightSum < 0) {
            rightSum = 0;
        }
        sum[0] = Math.max(sum[0], leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        maxPath(root, sum);
        return sum[0];
    }
}