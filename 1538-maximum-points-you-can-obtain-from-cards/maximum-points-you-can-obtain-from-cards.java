class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        int Lsum = 0;
        int Rsum = 0;

        int right = cardPoints.length - 1;

        for (int i = 0; i < k; i++) {
            Lsum += cardPoints[i];
        }

        ans = Lsum;

        for (int i = k - 1; i >= 0; i--) {
            Lsum = Lsum - cardPoints[i];
            Rsum = Rsum + cardPoints[right];
            right--;

            ans = Math.max(ans, Lsum + Rsum);
        }

        return ans;
    }
}