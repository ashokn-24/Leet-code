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

    boolean[] prev = new boolean[k + 1];
    boolean[] curr = new boolean[k + 1];

    prev[0] = true;
    curr[0] = true;

    if (nums[0] <= k) {
     prev[nums[0]] = true;
    }
    for (int ind = 1; ind < n; ind++) {
      for (int tar = 1; tar <= k; tar++) {
        boolean notTake = prev[tar];
        boolean take = false;

        if (nums[ind] <= tar) {
          take = prev[tar - nums[ind]];
        }

        curr[tar] = take || notTake;
      }
      prev = Arrays.copyOf(curr, k + 1);
    }

    return prev[k];
  }
}