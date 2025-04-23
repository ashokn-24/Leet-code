class Solution {
  long check(int limit, int[] arr) {
    long totalHour = 0;
    for (int num : arr) {
      totalHour += (long) Math.ceil((double) num / limit);
    }
    return totalHour;
  }

  public int minEatingSpeed(int[] piles, int h) {
    int max = piles[0];
    for (int num : piles) {
      max = Math.max(max, num);
    }

    int low = 1;
    int high = max;
    int ans = 0;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (check(mid, piles) <= h) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }
}
