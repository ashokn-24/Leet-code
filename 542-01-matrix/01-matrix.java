class Solution {
    class Data {
        int row, col, dis;

        public Data(int r, int c, int d) {
            row = r;
            col = c;
            dis = d;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] result = new int[n][m];
        Queue<Data> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Data(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] drow = { 0, 0, 1, -1 };
        int[] dcol = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            Data temp = q.poll();
            int r = temp.row;
            int c = temp.col;
            int d = temp.dis;

            result[r][c] = d;

            for (int i = 0; i < 4; i++) {
                int row = r + drow[i];
                int col = c + dcol[i];

                if (row >= 0 && row < n &&
                        col >= 0 && col < m &&
                        vis[row][col] == 0) {
                    
                    vis[row][col] = 1;
                    q.add(new Data(row, col, d + 1));
                }
            }

        }

        return result;
    }
}