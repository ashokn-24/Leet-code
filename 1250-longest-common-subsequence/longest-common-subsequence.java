class Solution {
    int f(int i1, int i2, String text1, String text2, int[][] dp) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        char ch1 = text1.charAt(i1);
        char ch2 = text2.charAt(i2);

        if (ch1 == ch2) {
            return dp[i1][i2] = 1 + f(i1 - 1, i2 - 1, text1, text2, dp);
        } else {
            return dp[i1][i2] = Math.max(f(i1 - 1, i2, text1, text2, dp), f(i1, i2 - 1, text1, text2, dp));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(n1 - 1, n2 - 1, text1, text2, dp);
    }
}