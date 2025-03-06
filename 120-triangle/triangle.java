class Solution {

  int f(int row, int col, List<List<Integer>> triangle, int[][] dp) {
    int n = triangle.size();
    if (row == n - 1) {
      return triangle.get(n - 1).get(col);
    }

    if (dp[row][col] != -1) {
      return dp[row][col];
    }

    int down = triangle.get(row).get(col) + f(row + 1, col, triangle, dp);
    int dRht = triangle.get(row).get(col) + f(row + 1, col + 1, triangle, dp);

    return dp[row][col] = Math.min(down, dRht);
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();

    int[][] dp = new int[n][n];

    for (int j = 0; j < n; j++) {
      dp[n - 1][j] = triangle.get(n - 1).get(j);
    }

    for (int row = n - 2; row >= 0; row--) {
      for (int col = row; col >= 0; col--) {
          int down = triangle.get(row).get(col) + dp[row + 1][col];
          int dRht = triangle.get(row).get(col) + dp[row + 1][col + 1];
          dp[row][col] = Math.min(down, dRht);
      }
    }

    return dp[0][0];
  }
}