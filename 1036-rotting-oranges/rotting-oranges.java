

class Solution {
    class ThreeSome {
        int row, col, t;

        public ThreeSome(int r, int c, int tm) {
            row = r;
            col = c;
            t = tm;
        }
    }

    public int orangesRotting(int[][] grid) { 
        if(grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int freshOranges = 0;
        Queue<ThreeSome> q = new LinkedList<>();
    
        for(int i = 0; i < n ; i++){
            for(int j = 0; j< m ; j++){
                if(grid[i][j] == 2){
                    q.offer(new ThreeSome(i, j, 0));
                    vis[i][j] = 2;
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        int tm = 0;
        int[] drow = {0, 0, 1, -1};
        int[] dcol = {1, -1, 0, 0};

        int cnt = 0;

        while(!q.isEmpty()){
            ThreeSome temp = q.poll();
            int r = temp.row;
            int c = temp.col;
            int t = temp.t;
            tm = Math.max(tm, t);

            for(int i = 0; i < 4; i++){
                int row = r + drow[i];
                int col = c + dcol[i];    

                if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0 && grid[row][col] == 1){
                    q.add(new ThreeSome(row, col, t + 1));
                    vis[row][col] = 2;
                    cnt++;
                }
            }
        }

        return (cnt == freshOranges) ? tm : -1;
    }
}
