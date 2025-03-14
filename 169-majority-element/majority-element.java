class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for(var it : mp.entrySet()){
            if(it.getValue() > n / 2){
               res = it.getKey();
            }
        }

        return res;

    }
}