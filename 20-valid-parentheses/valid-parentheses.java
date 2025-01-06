class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
     
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                    st.add(s.charAt(i));
            } else {
                
                if (st.isEmpty()) {
                    return false;
                }

                char temp = st.pop();

                if (s.charAt(i) == ')' && temp == '(' || 
                    s.charAt(i) == '}' && temp == '{' ||
                    s.charAt(i) == ']' && temp == '[') {
                    continue;
                }else{
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}