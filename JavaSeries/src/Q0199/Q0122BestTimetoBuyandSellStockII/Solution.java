package Q0199.Q0122BestTimetoBuyandSellStockII;

public class Solution {
    /*
       case 1. 交易为,相邻两天股票价格涨了;
       case 2. 一直涨, 如: 3 5 8; 可拆成 case 1
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
        return res;
    }
}
