package Q0199.Q0123BestTimetoBuyandSellStockIII;

import java.util.Arrays;

public class Solution3 {
    /*
   We need to save min for each transaction, so there are k 'min'.
We can find the second dimension (variable i) is only dependent on the previous one (i-1), so we can compact this dimension. (We can choose the first dimension (variable k) as well since it is also only dependent on its previous one k-1, but can't compact both.)
 */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[3];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - dp[k - 1]);
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
            }
        }

        return dp[2];
    }
    // So time complexity is O(kn), space complexity becomes O(k).
}
