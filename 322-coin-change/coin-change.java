class Solution {
  int f(int i, int amt, int[] coins, int[][] dp) {
    if (amt == 0) {
      return 0;
    }

    if (i == 0) {
      if (amt % coins[i] == 0) {
        return amt / coins[i];
      } else {
        return Integer.MAX_VALUE;
      }
    }

    if (dp[i][amt] != -1) {
      return dp[i][amt];
    }

    int notPick = 0 + f(i - 1, amt, coins, dp);
    int pick = Integer.MAX_VALUE;

    if (coins[i] <= amt) {
      int res = f(i, amt - coins[i], coins, dp);
      if (res != Integer.MAX_VALUE) {
        pick = 1 + res;
      }
    }

    return dp[i][amt] = Math.min(pick, notPick);
  }

  public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    int ans = f(n - 1, amount, coins, dp);

    return (ans >= Integer.MAX_VALUE) ? -1 : ans;
  }
}