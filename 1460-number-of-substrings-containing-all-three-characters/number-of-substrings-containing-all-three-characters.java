class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int[] hash = { -1, -1, -1 };
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hash[ch - 'a'] = i;
            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                int minHash = Math.min(hash[0],Math.min(hash[1],hash[2]));
                cnt = cnt + minHash + 1;
            }
        }

        return cnt;
    }

}