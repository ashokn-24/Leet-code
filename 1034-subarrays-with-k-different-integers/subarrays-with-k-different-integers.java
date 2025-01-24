class Solution {
    public int func(int[] nums, int k) {
        int cnt = 0;
        int left = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            mp.put(nums[right], mp.getOrDefault(nums[right], 0) + 1);

            while (mp.size() > k) {
                mp.put(nums[left], mp.getOrDefault(nums[left], 0) - 1);
                if (mp.get(nums[left]) == 0)
                    mp.remove(nums[left]);

                left++;
            }

            if (mp.size() <= k) {
                cnt += right - left + 1;
            }
        }

        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int a = func(nums,k);
        int b = func(nums,k - 1);

        return a-b;
    }
}