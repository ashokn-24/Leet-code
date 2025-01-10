class Solution {
    static int[] findPse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.add(i);
        }
        return ans;
    }

    static int[] findNse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.add(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] pse = findPse(heights);
        int[] nse = findNse(heights);
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (nse[i] - pse[i] - 1));
        }

    return max;
    }
}