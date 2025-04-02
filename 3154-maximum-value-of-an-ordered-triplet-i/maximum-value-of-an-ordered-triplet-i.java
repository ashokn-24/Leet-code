class Solution {
    public long maximumTripletValue(int[] nums) {
        long result = Long.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long temp = ((long) (nums[i] - nums[j])) * nums[k];
                    result = Math.max(temp, result);
                }
            }
        }

        return result < 0 ? 0 : result;
    }
}