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

    class Data{
        TreeNode node;
        int row;
        int col;

    public Data(TreeNode root,int X,int Y){
            node = root;
            row = X;
            col = Y;
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Data> q = new LinkedList<>();

        q.offer(new Data(root, 0, 0));

        while (!q.isEmpty()) {
            Data p = q.poll();
            TreeNode temp = p.node;
            int ver = p.row;
            int lvl = p.col;

            if (!mp.containsKey(ver)) {
                mp.put(ver, new TreeMap<>());
            }

            if (!mp.get(ver).containsKey(lvl)) {
                mp.get(ver).put(lvl, new PriorityQueue<>());
            }

            mp.get(ver).get(lvl).add(temp.val);

            if (temp.left != null) {
                q.offer(new Data(temp.left, ver - 1, lvl + 1));
            }

            if (temp.right != null) {
                q.offer(new Data(temp.right, ver + 1, lvl + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> entry : mp.entrySet()){
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : entry.getValue().values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll()); 
                }
            }
            res.add(col);
        }

        return res;
    }
}