class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (min < 0)
                return false;

            char ch = s.charAt(i);

            if (ch == '(') {
                min++;
                max++;
            } else if (ch == ')') {
                max--;
                min--;
            } else if (ch == '*') {
                min--;
                max++;
            }

            if (min < 0)
                min = 0;

            if (max < 0)
                return false;

        }

        return (min == 0);
    }
}