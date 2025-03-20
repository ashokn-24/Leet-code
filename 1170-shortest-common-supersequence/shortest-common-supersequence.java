class Solution {
    public String lcs(String text1, String text2) {
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

        int i = n1;
        int j = n2;
        StringBuilder ans = new StringBuilder("");

        while (i > 0 && j > 0) {
            char ch1 = text1.charAt(i - 1);
            char ch2 = text2.charAt(j - 1);
            if (ch1 == ch2) {
                ans.append(ch1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(ch1);
                i--;
            } else {
                ans.append(ch2);
                j--;
            }
        }

        while (i > 0) {
            ans.append(text1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            ans.append(text2.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        return lcs(str1, str2);
    }
}