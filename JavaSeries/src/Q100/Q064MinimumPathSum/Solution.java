package Q100.Q064MinimumPathSum;

public class Solution {
    /*
      This is a typical DP problem. Suppose the minimum path sum of arriving at point (i, j) is S[i][j], then the state
    equation is S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j].
      Well, some boundary conditions need to be handled. The boundary conditions happen on the topmost row (S[i - 1][j]
    does not exist) and the leftmost column (S[i][j - 1] does not exist). Suppose grid is like [1, 1, 1, 1], then the
    minimum sum to arrive at each point is simply an accumulation of previous points and the result is [1, 2, 3, 4].
      Now we can write down the following (unoptimized) code.
     */
    public int minPathSum1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m][n];
        minSum[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 若 i = 0, 就不计算 i - 1，否则越界
                if (i == 0 && j > 0) minSum[i][j] = minSum[i][j - 1] + grid[i][j];
                else if (j == 0 && i > 0) minSum[i][j] = minSum[i - 1][j] + grid[i][j];
                else if (i > 0 && j > 0) minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i - 1][j]) + grid[i][j];
            }
        }
        return minSum[m - 1][n - 1];
    }

    /*
      As can be seen, each time when we update sum[i][j], we only need sum[i - 1][j] (at the current column) and
      sum[i][j - 1] (at the left column). So we need not maintain the full m*n matrix. Maintaining two columns is enough
      and now we have the following code.
     */
    public int minPathSum2(int[][] grid) {
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

    /*
      Further inspecting the above code, it can be seen that maintaining pre is for recovering pre[i], which is simply
      cur[i] before its update. So it is enough to use only one vector. Now the space is further optimized and the code
      also gets shorter.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] cur = new int[m];
        cur[0] = grid[0][0];

        for (int i = 1; i < m; i++)
            cur[i] = cur[i - 1] + grid[i][0];

        for (int j = 1; j < n; j++) {
            cur[0] += grid[0][j];
            for (int i = 1; i < m; i++)
                cur[i] = Math.min(cur[i - 1], cur[i]) + grid[i][j];
        }
        return cur[m - 1];
    }
}