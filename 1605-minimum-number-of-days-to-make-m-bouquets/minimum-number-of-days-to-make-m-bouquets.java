class Solution {

  int check(int[] arr, int day, int m, int k) {
    int b = 0;
    int cnt = 0;
    
    for (int num : arr) {
      if (num <= day) {
        cnt++;
      } else {
        cnt = 0;
      }

      if (cnt == k) {
        b++;
        cnt = 0;
      }
    }

    return b;
  }

  public int minDays(int[] bloom, int m, int k) {
    int min = bloom[0];
    int max = bloom[0];

    for (int num : bloom) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }

    int low = min;
    int high = max;

    int res = -1;
    while (low <= high) {
      int mid = (low + high) / 2;

      if (check(bloom, mid, m, k) >= m) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return (res);
  }
}