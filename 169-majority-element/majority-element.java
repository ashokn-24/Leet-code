class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int ele = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cnt++;
                ele = nums[i];
            } else if (ele == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        int c = 0;
        cnt = 0;
        for (int num : nums) {
            if (num == ele)
                cnt++;
        }

        if (cnt > nums.length / 2)
            return ele;

        return -1;
    }
}