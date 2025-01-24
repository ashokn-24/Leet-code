class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int children = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0 ;
        int right = 0;

        while(left < s.length && right < g.length ){
            if(s[left] >= g[right]){
                children++;
            right++;
            }
            left++;
        }
        return children;
    }
}