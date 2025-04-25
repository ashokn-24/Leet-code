class Solution {
  int check(int maxSum, int k, int[] arr) {
    int sum = 0;
    int cnt = 1;

    for (int num : arr) {
      if (sum + num <= maxSum) {
        sum += num;
      } else {
        cnt++;
        sum = num;
      }
    }

    return cnt;
  }

  public int splitArray(int[] nums, int k) {
    int max = nums[0];
    int sum = 0;

    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }

    int low = max;
    int high = sum;
    int res = 0;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (check(mid, k, nums) <= k) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return res;
  }
}