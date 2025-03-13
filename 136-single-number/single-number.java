class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer>  mp = new HashMap<>();

        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for(var num: mp.entrySet()){
            if(num.getValue() == 1){
                return num.getKey();
            }
        }

        return -1;
    }
}