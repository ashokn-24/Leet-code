class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int preSum[] = new int[n];
        preSum[0] = s.charAt(0) - '0';

        for (int i = 1; i < n; i++) {
            int num = s.charAt(i) - '0';
            preSum[i] = num + preSum[i - 1];
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = (i + 1) - preSum[i];
            int right = preSum[n - 1] - preSum[i];
            res = Math.max(res, left + right);
        }

        return res;
    }
}