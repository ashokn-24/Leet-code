class Solution {
    class DisjointSet {
        int[] size, parent;

        public DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        int find(int x) {
            if (x == parent[x]) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int parX = find(x);
            int parY = find(y);

            if (parX == parY) {
                return;
            }

            if (size[parX] >= size[parY]) {
                parent[parY] = parX;
                size[parX] += size[parY];
            } else {
                parent[parX] = parY;
                size[parY] += size[parX];
            }
        }
    }

    public int makeConnected(int n, int[][] edge) {
        DisjointSet ds = new DisjointSet(n);

        int extraEdge = 0;

        for (int[] it : edge) {
            int u = it[0];
            int v = it[1];

            if (ds.find(u) == ds.find(v)) {
                extraEdge++;
            } else {
                ds.union(u, v);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) {
                cnt++;
            }
        }

        if (extraEdge >= cnt - 1) {
            return cnt - 1;
        }

        return -1;
    }
}