class Solution {
  public boolean check(int[] nums) {

    int cnt = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        cnt++;
      }
    }

    if (nums[nums.length - 1] > nums[0]) {
      cnt++;
    }

    return cnt <= 1;
  }
}