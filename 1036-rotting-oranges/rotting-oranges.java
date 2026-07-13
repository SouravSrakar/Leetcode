import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        int cntFresh = 0;

        // Store all rotten oranges in queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int time = 0;
        int cnt = 0;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {

                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if (nRow >= 0 && nRow < n &&
                    nCol >= 0 && nCol < m &&
                    vis[nRow][nCol] == 0 &&
                    grid[nRow][nCol] == 1) {

                    vis[nRow][nCol] = 2;
                    cnt++;

                    q.offer(new int[]{nRow, nCol, t + 1});
                }
            }
        }

        if (cnt != cntFresh) {
            return -1;
        }

        return time;
    }
}