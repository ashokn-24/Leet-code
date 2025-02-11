class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int v = numCourses;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int w = prerequisites[i][0];
            int u = prerequisites[i][1];

            adj.get(u).add(w);
        }

        int[] indeg = new int[v];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indeg[it]++;
            }
        }

        for (int i = 0; i < v; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indeg[it]--;

                if (indeg[it] == 0) {
                    q.add(it);
                }
            }
        }

        int[] resArray = new int[topo.size()];

        for(int i = 0; i < resArray.length;i++){
            resArray[i] = topo.get(i);
        }

        if (topo.size() == v)
            return resArray;

        int[] ans ={}; 
        return ans;
    }
}