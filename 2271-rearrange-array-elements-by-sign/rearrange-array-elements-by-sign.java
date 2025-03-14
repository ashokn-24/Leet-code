class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            nums[i * 2] = pos.get(i);
            nums[i * 2 + 1] = neg.get(i);
        }

        return nums;
    }
}