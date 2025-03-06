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

    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return f(0, 0, triangle, dp);
  }
}