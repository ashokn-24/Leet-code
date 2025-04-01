class Solution {
    long f(int i, int[][] qus, long[] dp) {
        if (i >= qus.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        long skip = f(i + 1, qus, dp);
        long solve = qus[i][0] + f(i + qus[i][1] + 1, qus, dp);

        return dp[i] = Math.max(skip, solve);
    }

    public long mostPoints(int[][] qus) {
        int n = qus.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);

        return f(0, qus, dp);
    }
}