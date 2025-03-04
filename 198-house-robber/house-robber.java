class Solution {
    public int sum(int i, int[] nums, int[] dp) {
        if (i == 0) {
            return nums[i];
        }
        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int pick = nums[i] + sum(i - 2, nums, dp);
        int notpick = 0 + sum(i - 1, nums, dp);

        return dp[i] = Math.max(pick, notpick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int pre1 = nums[0];
        int pre2 = 0;

        for(int i = 1; i < n; i++){
            int take = nums[i];
            
            if(i > 1){
                take += pre2;
            }

            int notTake = 0 + pre1;

            int curr = Math.max(take, notTake);

            int tmp = pre1;
            pre2 = tmp;
            pre1 = curr;
        }

        return pre1;
    }
}