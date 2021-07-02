package Q0199.Q0123BestTimetoBuyandSellStockIII;

public class Solution1 {
    /*
   It's not difficult to get the DP recursive formula:

dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
For k transactions, on i-th day,
if we don't trade then the profit is same as previous day dp[k, i-1];
and if we bought the share on j-th day where j=[0..i-1], then sell the share on i-th day then the profit is prices[i] - prices[j] + dp[k-1, j-1] .
Actually j can be i as well. When j is i, the one more extra item prices[i] - prices[j] + dp[k-1, j] = dp[k-1, i] looks like we just lose one chance of transaction.

I see someone else use the formula dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j]), where the last one is dp[k-1, j] instead of dp[k-1, j-1]. It's not the direct sense, as if the share was bought on j-th day, then the total profit of previous transactions should be done on (j-1)th day. However, the result based on that formula is also correct, because if the share was sold on j-th day and then bought again, it is the same if we didn't trade on that day.

So the straightforward implementation is:
 */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++)
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][prices.length - 1];
    }
    // Time complexity is O(kn^2), space complexity is O(kn).

}
