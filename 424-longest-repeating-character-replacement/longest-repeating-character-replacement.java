class Solution {
  public int characterReplacement(String s, int k) {
    int left = 0;
    int maxLen = 0;
    Map<Character, Integer> mp = new HashMap<>();
    int maxFreq = 0;

    for (int right = 0; right < s.length(); right++) {
      char ch = s.charAt(right);
      mp.put(ch, mp.getOrDefault(ch, 0) + 1);

      maxFreq = Math.max(maxFreq, mp.get(ch));

      if ((right - left + 1) - maxFreq > k) {
        char lft = s.charAt(left);
        mp.put(lft, mp.getOrDefault(lft, 0) - 1);
        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }
}