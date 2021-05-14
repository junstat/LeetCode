package Q0199.Q0162FindPeakElement;

import org.junit.Test;


/*
   Binary Search: iteration
 */
public class Solution {
    @Test
    public void test2() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) low = mid2;
            else high = mid1;
        }
        return low;
    }
}
