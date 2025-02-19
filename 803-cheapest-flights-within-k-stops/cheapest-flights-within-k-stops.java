class Solution {

    class Pair {
        int node, wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    class Data {
        int dis, node, st;

        public Data(int st, int node, int dis) {
            this.dis = dis;
            this.node = node;
            this.st = st;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int v = flights.length;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            int u = flights[i][0];
            int e = flights[i][1];
            int w = flights[i][2];

            adj.get(u).add(new Pair(e, w));
        }

        Queue<Data> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));

        dist[src] = 0;
        q.add(new Data(0, src, 0));

        while (!q.isEmpty()) {
            Data temp = q.poll();
            int stop = temp.st;
            int node = temp.node;
            int dis = temp.dis;

            if (stop > k)
                continue;

            for (Pair it : adj.get(node)) {
                int neighbor = it.node;
                int wt = it.wt;

                if (dis + wt < dist[neighbor] && stop <= k) {
                    dist[neighbor] = dis + wt;
                    q.add(new Data(stop + 1, neighbor, dist[neighbor]));
                }
            }
        }

        if (dist[dst] == 1e9)
            return -1;

        return dist[dst];

    }
}