class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length < 2) return true;

        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] % 2 == 0 && last % 2 != 0 || last % 2 == 0 && nums[i] % 2 != 0){
                last = nums[i];
            }else{
                return false;
            }
        }
        return true;
    }
}