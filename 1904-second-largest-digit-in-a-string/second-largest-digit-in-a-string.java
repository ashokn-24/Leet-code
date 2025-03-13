class Solution {
    public int secondHighest(String s) {
        int lar = -1;
        int sLar = -1;

        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                int num = ch - '0';
                if (num > lar) {
                    sLar = lar;
                    lar = num;
                } else if (num > sLar && num != lar) {
                    sLar = num;
                }
            }
        }

        return sLar;
    }
}