class Solution {
  int f(int ind, int[] nums, List<Integer> subset) {
    if (ind >= nums.length) {
      if (subset.size() > 1) {
        int xor = 0;
        for (int num : subset) {
          xor ^= num;
        }
        return xor;
      } else if (subset.size() == 1) {
        return subset.get(0);
      } else {
        return 0;
      }
    }

    int notTake = f(ind + 1, nums, subset);

    subset.add(nums[ind]);
    int take = f(ind + 1, nums, subset);

    return notTake + take;
  }

  public int subsetXORSum(int[] nums) {
    int n = nums.length;
    int totalSum[] = new int[1];
    List<Integer> subset = new ArrayList<>();

    return f(0, nums, subset);
  }
}