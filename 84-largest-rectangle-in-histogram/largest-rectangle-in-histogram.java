class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
            }

            st.add(i);
        }

        while (!st.isEmpty()) {
            int nse = heights.length;
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
        }

        return maxArea;

    }
}