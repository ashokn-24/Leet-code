class Solution {

    public void dfs(int r, int c, int[][] vis, int[][] grid, int[] drow, int[] dcol) {
        vis[r][c] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int row = r + drow[i];
            int col = c + dcol[i];

            if (row >= 0 && row < n && col >= 0 && col < m &&
                    vis[row][col] == 0 && grid[row][col] == 1) {
                dfs(row, col, vis, grid, drow, dcol);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int[] drow = { 0, 0, 1, -1 };
        int[] dcol = { 1, -1, 0, 0 };

        for (int i = 0; i < m; i++) {
            if (vis[0][i] == 0 && grid[0][i] == 1) {
                dfs(0, i, vis, grid, drow, dcol);
            }

            if (vis[n - 1][i] == 0 && grid[n - 1][i] == 1) {
                dfs(n - 1, i, vis, grid, drow, dcol);
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && grid[i][0] == 1) {
                dfs(i, 0, vis, grid, drow, dcol);
            }

            if (vis[i][m - 1] == 0 && grid[i][m - 1] == 1) {
                dfs(i, m - 1, vis, grid, drow, dcol);
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;

    }
}