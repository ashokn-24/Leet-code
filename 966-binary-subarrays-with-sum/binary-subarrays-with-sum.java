class Solution {
  int check(int[] nums, int goal) {
    if (goal < 0)
      return 0;

    int left = 0;
    int subArrayCnt = 0;
    int sum = 0;

    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];

      while (sum > goal) {
        sum -= nums[left];
        left++;
      }

      subArrayCnt += right - left + 1;
    }

    return subArrayCnt;
  }

  public int numSubarraysWithSum(int[] nums, int goal) {
    int a = check(nums, goal);
    int b = check(nums, goal - 1);

    return a - b;
  }
}