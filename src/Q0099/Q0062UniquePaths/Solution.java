package Q0099.Q0062UniquePaths;

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
    public int uniquePaths(int rows, int cols) {
        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; row++) dp[row][0] = 1;

        for (int col = 0; col < cols; col++) dp[0][col] = 1;

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[rows - 1][cols - 1];
    }
}
/*
   Similar questions:
    91. Decode Ways
    70. Climbing Stairs
    509. Fibonacci Number
 */