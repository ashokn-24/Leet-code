class Solution {

    public boolean bfs(int row, int[][] graph, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(row);
        vis[row] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : graph[node]) {
                if (vis[it] == -1) {
                    if (vis[node] == 0) {
                        vis[it] = 1;
                    } else {
                        vis[it] = 0;
                    }
                    q.add(it);
                } else if (vis[it] == vis[node]) {
                    return false;
                }
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
                if (bfs(i, graph, vis) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}