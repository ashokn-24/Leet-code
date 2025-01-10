class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!st.isEmpty() && st.peek() > ch && k > 0) {
                st.pop();
                k--;
            }
            st.add(ch);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        for (char ch : st) {
            res.append(ch);
        }

        while (res.length() != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}