class Solution {
    public int trap(int[] arr) {
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int sum = 0;

        while (left < right) {
            if (arr[left] <= arr[right]) {
                if (leftMax > arr[left]) {
                    sum += leftMax - arr[left];
                } else {
                    leftMax = arr[left];
                }
                left++;
            } else {
                if (rightMax > arr[right]) {
                    sum += rightMax - arr[right];
                } else {
                    rightMax = arr[right];
                }
                right--;
            }
        }
        return sum;
    }
}