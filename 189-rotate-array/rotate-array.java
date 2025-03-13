class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        List<Integer> tmp = new ArrayList<>();

        for (int i = n - k; i < n; i++) {
            tmp.add(nums[i]);
        }

        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tmp.get(i);
        }
    }
}