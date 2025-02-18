class Solution {

    static class Data {
        int dis, row, col;

        public Data(int dis, int row, int col) {
            this.dis = dis;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        PriorityQueue<Data> pq = new PriorityQueue<>((x, y) -> x.dis - y.dis);
        int[][] dist = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        pq.add(new Data(0, 0, 0));
        dist[0][0] = 0;

        int[] drow = { 0, 0, 1, -1 };
        int[] dcol = { 1, -1, 0, 0 };

        while (!pq.isEmpty()) {
            Data temp = pq.poll();
            int dis = temp.dis;
            int r = temp.row;
            int c = temp.col;

            if (r == rows - 1 && c == columns - 1) {
                return dis;
            }

            for (int i = 0; i < 4; i++) {
                int row = r + drow[i];
                int col = c + dcol[i];

                if (row >= 0 && row < rows && col >= 0 && col < columns) {
                    int maxEf = Math.max(Math.abs(heights[r][c] - heights[row][col]), dis);

                    if (maxEf < dist[row][col]) {
                        dist[row][col] = maxEf;
                        pq.add(new Data(maxEf, row, col));
                    }
                }
            }

        }

        return -1;
    }
}