package Q0199.Q0121BestTimetoBuyandSellStock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
   Kadane's Algorithm - Since no one has mentioned about this so far :) (In case if interviewer twists the input)

   The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned this so far, I thought it's a good thing for everybody to know.

All the straight forward solution should work, but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.

Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
 */
public class Solution {

    @Test
    public void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(maxProfit(prices), 5);
    }

    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
