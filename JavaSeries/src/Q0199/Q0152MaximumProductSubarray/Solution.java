package Q0199.Q0152MaximumProductSubarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {
    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        assertEquals(maxProduct(nums), 6);
    }

    public int maxProduct(int[] nums) {
        // store the result that is the max we have found so far
        int r = nums[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number nums[i]
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extreums by swapping them
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }
}
