class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        while (right < n) {
            char ch = s.charAt(right);
            if (mp.containsKey(ch)) {
                if (mp.get(ch) >= left) {
                    left = mp.get(ch) + 1;
                }
            }
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            mp.put(ch, right);
            right++;
        }

        return maxLen;
    }
}