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

    public List<Integer> right(TreeNode root,int level,List res){
        if(root == null){
            return res;
        }

        if(level == res.size()){
            res.add(root.val);
        }

        right(root.right,level+1,res);
        right(root.left,level+1,res);

        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int level = 0;
        right(root,level,res);

        return res;
    }
}