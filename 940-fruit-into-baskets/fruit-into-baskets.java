class Solution {
  public int totalFruit(int[] arr) {
    int cnt = 0;
    int maxLen = 0;
    int left = 0;
    Map<Integer, Integer> mp = new HashMap<>();

    for (int right = 0; right < arr.length; right++) {
      mp.put(arr[right], mp.getOrDefault(arr[right], 0) + 1);

      while (mp.size() > 2) {
        mp.put(arr[left], mp.getOrDefault(arr[left], 0) - 1);

        if (mp.get(arr[left]) == 0) {
          mp.remove(arr[left]);
        }

        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);

    }

    return maxLen;
  }
}