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
        long[] dp = new long[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            long skip = dp[i + 1];
            int brainPt = i + qus[i][1] + 1;

            if (brainPt > n) {
                brainPt = 0;
            }

            long solve = qus[i][0] + dp[brainPt];

            dp[i] = Math.max(skip, solve);
        }

        return dp[0];
    }
}