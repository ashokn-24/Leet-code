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

  public int maximalRectangle(char[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    int[][] presum = new int[n][m];

    for (int j = 0; j < m; j++) {
      presum[0][j] = mat[0][j] - '0';
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == '1') {
          presum[i][j] = presum[i - 1][j] + 1;
        } else {
          presum[i][j] = 0;
        }
      }
    }

    int res = 0;

    for (int[] r : presum) {
      int area = largestRectangleArea(r);
      res = Math.max(res, area);
    }

    return res;
  }
}