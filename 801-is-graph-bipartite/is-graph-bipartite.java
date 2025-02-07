class Solution {

    public boolean dfs(int node, int color, int[][] graph, int[] vis) {
        vis[node] = color;
        for (int it : graph[node]) {
            if (vis[it] == -1) {
                if (dfs(it, 1 - color, graph, vis) == false) {
                    return false;
                }
            } else if (vis[it] == color) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                if (dfs(i, 0, graph, vis) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}