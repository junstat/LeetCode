package Q0299.Q0209MinimumSizeSubarraySum;

import org.junit.Test;

/*
   two pointers
   1. 用 i 、start 去夹
   2. win 做窗口
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, start = 0, win = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                win = Math.min(win, i - start + 1);
                sum -= nums[start++];
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }
}
