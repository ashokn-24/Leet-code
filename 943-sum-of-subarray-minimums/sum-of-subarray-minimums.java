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

  public int sumSubarrayMins(int[] arr) {
    int[] nse = findNse(arr);
    int[] pse = findPse(arr);

    int res = 0;
    int mod = (int) 1e9 + 7;

    for (int i = 0; i < arr.length; i++) {
      int pre = i - pse[i];
      int nxt = nse[i] - i;

      res = (res + (int) ((long) arr[i] * pre % mod * nxt % mod)) % mod;

    }

    return res;
  }
}