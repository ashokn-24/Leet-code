class Solution {
  int check(int divisor, int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num / divisor + (num % divisor == 0 ? 0 : 1);
    }

    return sum;
  }

  public int smallestDivisor(int[] nums, int threshold) {
    int max = nums[0];

    for (int num : nums) {
      max = Math.max(max, num);
    }

    int low = 1;
    int high = max;
    int res = max;
    while (low <= high) {
      int mid = (low + high) / 2;

      if (check(mid, nums) <= threshold) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }

    }

    return res;
  }
}