class Solution {
    public boolean check(String s,int x, int y){
        while(x < y && !Character.isLetterOrDigit(s.charAt(x))){
            x++;
        }

        while(x < y && !Character.isLetterOrDigit(s.charAt(y))){
            y--;
        }

        if(x >= y){
            return true;
        }

        char l = Character.toLowerCase(s.charAt(x));
        char r = Character.toLowerCase(s.charAt(y));

        if(l != r){
            return false;
        }

        return check(s, x +1 , y-1);
    }
    public boolean isPalindrome(String s) {
        return check(s, 0 ,s.length() - 1);
    }
}