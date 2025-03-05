class Solution {
    public int f(int row, int col, int[][] obstacleGrid , int[][] dp){
      if(row >= 0 && col >= 0 && obstacleGrid[row][col] == 1){
        return 0;
      }

      if(row == 0 && col == 0){
        return 1;
      }

      if(row < 0 || col < 0 || obstacleGrid[row][col] == 1){
        return 0;
      }

      if(dp[row][col] != -1){
        return dp[row][col];
      }

      int up = f(row - 1, col,obstacleGrid, dp);
      int lft = f(row, col - 1,obstacleGrid, dp);

      return dp[row][col] = up + lft;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
          Arrays.fill(dp[i], -1);
        }
        return f(n - 1, m - 1, obstacleGrid, dp);
    }
}