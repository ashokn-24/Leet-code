class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long preMax[] = new long[n];
        long suffMax[] = new long[n];
        long res = 0;

        preMax[0] = nums[0];
        suffMax[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffMax[i] = Math.max(nums[i], suffMax[i + 1]);
        }

        for (int j = 1; j < n - 1; j++) {
            long temp = ((long) (preMax[j - 1] - nums[j])) * suffMax[j + 1];
            res = Math.max(res, temp);
        }

        return res;

    }
}