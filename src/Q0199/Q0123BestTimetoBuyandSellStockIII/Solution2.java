package Q0199.Q0123BestTimetoBuyandSellStockIII;

public class Solution2 {
    // In the above code, min is repeated calculated. It can be easily improved as:
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];

        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][prices.length - 1];
    }
}
