
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        // Min Heap
        // Store {number of soldiers, row index}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );

        // Count soldiers in every row
        for (int i = 0; i < mat.length; i++) {

            int soldiers = 0;

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    soldiers++;
                }
            }

            pq.offer(new int[]{soldiers, i});
        }

        // Get k weakest rows
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[1];
        }

        return ans;
    }
}