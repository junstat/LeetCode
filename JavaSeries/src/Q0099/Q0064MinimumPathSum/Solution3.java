package Q0099.Q0064MinimumPathSum;

public class Solution3 {
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
