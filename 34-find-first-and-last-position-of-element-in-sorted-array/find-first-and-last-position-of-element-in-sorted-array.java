class Solution {

  int first(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int ans = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (arr[mid] >= target) {
        if (arr[mid] == target)
          ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  int last(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int ans = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (arr[mid] == target) {
          ans = mid;
          low = mid + 1;
      } else if(arr[mid] < target) {
        low = mid + 1;
      }else{
        high = mid - 1;
      }
    }

    return ans;
  }

  public int[] searchRange(int[] nums, int target) {
    int n = nums.length;

    int a = first(nums, target);
    int b = last(nums, target);

    return new int[] { a, b };
  }
}