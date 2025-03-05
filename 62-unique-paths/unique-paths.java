class Solution {
    int f(int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return 1;
        }

        if(row < 0 || col < 0 ){
            return 0;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int right = f(row, col - 1, dp);
        int down = f(row - 1, col, dp);
        
        return dp[row][col] = right + down;
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        return f(m - 1, n - 1, dp);
    }
}