class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[v];

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int it : graph[i]) {
                adj.get(it).add(i);
                inDeg[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);

            for (int it : adj.get(node)) {
                inDeg[it]--;

                if (inDeg[it] == 0) {
                    q.add(it);
                }
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }
}