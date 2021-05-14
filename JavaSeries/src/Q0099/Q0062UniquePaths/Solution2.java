package Q0099.Q0062UniquePaths;

public class Solution2 {
    /*
   The above solution runs in O(m * n) time and costs O(m * n) space. However, you may have noticed that each time
   when we update dp[i][j], we only need dp[i - 1][j] (at the previous row) and dp[i][j - 1] (at the current row).
   So we can reduce the memory usage to just two rows (O(n)).
   对于 dp[i][j] 只依赖上一行和当前行，所以只维护这两行就好了。
 */
    public int uniquePaths(int rows, int cols) {
        int[] cur = new int[cols];
        int[] pre = new int[cols];

        for (int i = 0; i < cols; i++) {
            pre[i] = 1;
            cur[i] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++)
                cur[j] = cur[j - 1] + pre[j];
            pre = cur;
        }

        return cur[cols - 1];
    }
}
