class Solution {
  int f(int row, int col, int[][] grid, int[][] dp) {
    if (row == 0 && col == 0)
      return grid[0][0];
    if (row < 0 || col < 0)
      return (int) 1e9;

    if (dp[row][col] != -1) {
      return dp[row][col];
    }

    int up = grid[row][col] + f(row - 1, col, grid, dp);
    int left = grid[row][col] + f(row, col - 1, grid, dp);

    return dp[row][col] = Math.min(up, left);
  }

  public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 && j == 0) {
          dp[0][0] = grid[0][0];
        } else {
          int up = grid[i][j];
          int lft = grid[i][j];

          up += (i > 0) ? dp[i - 1][j] : (int) 1e9;
          lft += (j > 0) ? dp[i][j - 1] : (int) 1e9;
          dp[i][j] = Math.min(up, lft); 
        }
      }
    }

    return dp[n - 1][m - 1];
  }
}