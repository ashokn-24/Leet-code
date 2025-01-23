class Solution {
    public int characterReplacement(String s, int k) {
        int count = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        int[] ans = new int[26];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int freq = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            ans[ch - 'A']++;
            // mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            freq = Math.max(freq, ans[ch - 'A']);

            if ((right - left + 1) - freq > k) {
                char lft = s.charAt(left);
                ans[lft-'A']--;
                // mp.put(lft, mp.get(lft) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}