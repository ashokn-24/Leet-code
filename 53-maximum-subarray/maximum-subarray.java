class Solution {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;

    if (nums.length == 0) {
      return nums[0];
    }

    for (int num : nums) {
      // if (nums.length == 0) {
      //   return nums[i];
      // }
      sum += num;

      max = Math.max(sum, max);
      if (sum < 0) {
        sum = 0;
      }

    }

    return max;
  }
}