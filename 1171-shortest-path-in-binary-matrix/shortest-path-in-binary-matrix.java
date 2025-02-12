class Solution {

    class Src {
        int dis, row, col;

        public Src(int d, int r, int c) {
            dis = d;
            row = r;
            col = c;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
         
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        int[][] directions = {
            {0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}
        };

        Queue<Src> q = new LinkedList<>();
        int[][] vis = new int[n][n];

        q.add(new Src(1,0,0));
        vis[0][0] = 1;

        while(!q.isEmpty()){
            Src temp = q.poll();
            int r = temp.row;
            int c = temp.col;
            int d = temp.dis;

            if (r == n - 1 && c == n - 1) {
                return d;
            }

            for(int i =0 ; i < 8;i++){
                int drow = r + directions[i][0]; 
                int dcol = c + directions[i][1]; 


                if(drow >= 0 && drow < n && dcol >= 0 && dcol < n && vis[drow][dcol] == 0 && grid[drow][dcol] == 0){
                    vis[drow][dcol] =1;
                    q.add(new Src(d + 1, drow,dcol));
                }
            }
        }

        return -1;
    }
}