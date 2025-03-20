class Solution {
    public int lcs(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n2; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char ch1 = text1.charAt(i - 1);
                char ch2 = text2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n1][n2];
    }

    public int lps(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s, t);
    }

    public int minInsertions(String s) {
        int lps = lps(s);
        int n = s.length();

        return n - lps;
    }
}