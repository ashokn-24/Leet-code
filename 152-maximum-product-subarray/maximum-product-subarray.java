class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int prex = 1;
        int sufx = 1;
        int n = nums.length;

        for(int i = 0 ; i < n;i++){
            if(prex == 0) prex = 1;
            if(sufx == 0) sufx = 1;

            prex = prex * nums[i];
            sufx = sufx * nums[n - i - 1];
            
            int maxSum = Math.max(prex,sufx);
            ans = Math.max(ans,maxSum);
        }

        return ans;
    }
}