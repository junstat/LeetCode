package Q0099.Q0064MinimumPathSum;

public class Solution2 {
    /*
    As can be seen, each time when we update sum[i][j], we only need sum[i - 1][j] (at the current column) and
    sum[i][j - 1] (at the left column). So we need not maintain the full m*n matrix. Maintaining two columns is enough
    and now we have the following code.
    */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] pre = new int[m];
        int[] cur = new int[m];

        pre[0] = grid[0][0];

        for (int i = 1; i < m; i++)
            pre[i] = pre[i - 1] + grid[i][0];

        for (int j = 1; j < n; j++) {
            cur[0] = pre[0] + grid[0][j];
            for (int i = 1; i < m; i++)
                cur[i] = Math.min(cur[i - 1], pre[i]) + grid[i][j];
            swapArray(pre, cur);
        }
        return pre[m - 1];
    }

    private void swapArray(int[] pre, int[] cur) {
        for (int i = 0; i < pre.length; i++) {
            int tmp = pre[i];
            pre[i] = cur[i];
            cur[i] = tmp;
        }
    }
}
