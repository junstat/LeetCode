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
        for (int price : prices) {
            min = Math.min(min, price);
            num = Math.max(num, price - min);
        }
        return num;
    }
}
