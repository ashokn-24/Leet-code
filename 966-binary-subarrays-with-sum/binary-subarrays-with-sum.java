class Solution {
    public int check(int[] nums, int k) {
        if (k < 0) return 0; 

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (right < nums.length) {   
            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int k) {
        int a = check(nums, k);
        int b = check(nums, k - 1);
        return a - b;
    }
}