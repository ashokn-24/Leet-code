class Solution {
    int f(int i, int amt, int[] coins, int[][] dp) {
        if (amt == 0) {
            return 1;
        }

        if (i == 0) {
            if (amt % coins[i] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[i][amt] != -1) {
            return dp[i][amt];
        }

        int notTake = f(i - 1, amt, coins, dp);
        int take = 0;

        if (coins[i] <= amt) {
            take = f(i, amt - coins[i], coins, dp);
        }

        return dp[i][amt] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(n - 1, amount, coins, dp);
    }
}