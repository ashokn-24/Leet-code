class Solution {

    public void dfs(int node,List<List<Integer>> adjLS, int[] vis){
        vis[node] = 1;
        for(Integer it: adjLS.get(node)){
            if(vis[it] == 0){
                dfs(it,adjLS,vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjLS = new ArrayList<>();

        for (int i = 0; i < isConnected[0].length; i++) {
            adjLS.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLS.get(i).add(j);
                    adjLS.get(j).add(i);
                }
            }
        }

        int[] vis = new int[isConnected[0].length];
        int cnt = 0;
        for(int i = 0; i < isConnected[0].length ;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i,adjLS,vis);
            }
        }

    return cnt;
    }
}