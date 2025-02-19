class Solution {
    class Pair {
        long wt;
        int node;

        public Pair(long wt, int node) {
            this.wt = wt;
            this.node = node;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.wt));

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0L, 0));
        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            long currentDist = temp.wt;
            int node = temp.node;

            if (currentDist > dist[node]) {
                continue;
            }

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                long edgeWt = it.wt;

                long newDist = currentDist + edgeWt;

                if (newDist < dist[adjNode]) {
                    dist[adjNode] = newDist;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(newDist, adjNode));
                } else if (newDist == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}