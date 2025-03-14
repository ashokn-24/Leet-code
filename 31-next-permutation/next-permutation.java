class Solution {
    void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    void rev(int start, int end, int[] nums) {
        while (start <= end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            rev(0, n - 1, nums);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[ind]) {
                swap(i, ind, nums);
                break;
            }
        }

        rev(ind + 1, n - 1, nums);
    }
}