class Solution {
    public int lengthOfLongestSubstring(String s) {
        int mp[] = new int[255];
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < n) {
            char ch = s.charAt(right);

            if (mp[ch] != 0 && mp[ch] >= left) {       
                    left = mp[ch];
            }

            maxLen = Math.max(maxLen, right - left + 1);
            mp[ch] = right + 1;
            right++;
        }

        return maxLen;

    }
}