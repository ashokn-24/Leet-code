class Solution {
    int f(int i1, int i2, String s, String t, int[][] dp) {
        if (i2 < 0) {
            return 1;
        }

        if (i1 < 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        char ch1 = s.charAt(i1);
        char ch2 = t.charAt(i2);

        if (ch1 == ch2) {
            return dp[i1][i2] = f(i1 - 1, i2 - 1, s, t, dp) + f(i1 - 1, i2, s, t, dp);
        } else {
            return dp[i1][i2] = f(i1 - 1, i2, s, t, dp);
        }
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n +1][m +1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = t.charAt(j -1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i -1][j- 1] + dp[i- 1][j];
                } else {
                    dp[i][j] = dp[i- 1][j];
                }
            }
        }

        return dp[n][m];
    }
}