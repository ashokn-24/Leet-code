class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (h[left] <= h[right]) {
                leftMax = Math.max(leftMax, h[left]);
                water += leftMax - h[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, h[right]);
                water += rightMax - h[right];
                right--;
            }
        }

        return water;
    }
}