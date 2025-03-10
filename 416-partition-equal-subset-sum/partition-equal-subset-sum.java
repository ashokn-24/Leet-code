class Solution {
  public boolean f(int ind, int k, int[] nums, int[][] dp) {
    if (k == 0) {
      return true;
    }
    if (ind == 0) {
      return nums[ind] == k;
    }

    if (dp[ind][k] != -1) {
      return dp[ind][k] == 1;
    }

    boolean notTake = f(ind - 1, k, nums, dp);
    boolean take = false;

    if (nums[ind] <= k) {
      take = f(ind - 1, k - nums[ind], nums, dp);
    }

    dp[ind][k] = (take || notTake) ? 1 : 0;
    return take || notTake;
  }

  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int s = 0;

    for (int num : nums) {
      s += num;
    }

    if (s % 2 != 0) {
      return false;
    }

    int k = s / 2;
    boolean[][] dp = new boolean[n][k + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }

    if (nums[0] <= k) {
      dp[0][nums[0]] = true;
    }
    for (int ind = 1; ind < n; ind++) {
      for (int tar = 1; tar <= k; tar++) {
        boolean notTake = dp[ind - 1][tar];
        boolean take = false;

        if (nums[ind] <= tar) {
          take = dp[ind - 1][tar - nums[ind]];
        }

        dp[ind][tar] = take || notTake;
      }
    }

    return dp[n - 1][k];
  }
}