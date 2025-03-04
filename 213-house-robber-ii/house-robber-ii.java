class Solution {

    public int f(int[] nums) {
        int n = nums.length;
        int pre1 = nums[0];
        int pre2 = 0;

        for (int i = 1; i < n; i++) {
            int take = nums[i];

            if (i > 1) {
                take += pre2;
            }

            int notTake = 0 + pre1;

            int curr = Math.max(take, notTake);

            int tmp = pre1;
            pre2 = tmp;
            pre1 = curr;
        }

        return pre1;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];

        if(n == 1){
            return nums[0];
        }

        for(int i = 0; i< n ; i++){
            if(i != 0) temp1[i] = nums[i];
            if(i != n - 1) temp2[i] = nums[i];
        }

        return Math.max(f(temp1),f(temp2));

    }
}