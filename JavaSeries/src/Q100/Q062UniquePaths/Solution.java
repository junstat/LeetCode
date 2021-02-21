package Q100.Q062UniquePaths;

/*
   DP 三部曲
   1. 化整为零
   2. 推导公式
   3. corner case
 */
public class Solution {
    /*
       Since the robot can only move right and down, when it arrives at a point, it either arrives from left or above.
       If we use dp[i][j] for the number of unique paths to arrive at the point (i, j), then the state equation is
       dp[i][j] = dp[i][j - 1] + dp[i - 1][j]. Moreover, we have the base cases
       dp[0][j] = dp[i][0] = 1 for all valid i and j. (robot 只能往右或者往下走一步，对于行边界，只能是往右走过来1种方式；同理，
       列边界只能往下1种方式)
     */
    public int uniquePaths1(int rows, int cols) {
        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; row++) dp[row][0] = 1;

        for (int col = 0; col < cols; col++) dp[0][col] = 1;

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[rows - 1][cols - 1];
    }

    /*
       The above solution runs in O(m * n) time and costs O(m * n) space. However, you may have noticed that each time
       when we update dp[i][j], we only need dp[i - 1][j] (at the previous row) and dp[i][j - 1] (at the current row).
       So we can reduce the memory usage to just two rows (O(n)).
       对于 dp[i][j] 只依赖上一行和当前行，所以只维护这两行就好了。
     */
    public int uniquePaths2(int rows, int cols) {
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

    /*
        Further inspecting the above code, pre[j] is just the cur[j] before the update. So we can further reduce the
         memory usage to one row.
     */
    public int uniquePaths(int rows, int cols) {
        int[] cur = new int[cols];

        for (int i = 0; i < cols; i++) cur[i] = 1;

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) cur[j] = cur[j - 1] + cur[j];

        return cur[cols - 1];
    }
}
/*
   Similar questions:
    91. Decode Ways
    70. Climbing Stairs
    509. Fibonacci Number
 */