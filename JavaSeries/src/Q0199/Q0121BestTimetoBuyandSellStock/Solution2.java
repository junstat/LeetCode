package Q0199.Q0121BestTimetoBuyandSellStock;

/*
   100%
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int min = prices[0];
        int num = 0;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, prices[i]);
            num = Math.max(num, prices[i] - min);
        }
        return num;

    }
}
