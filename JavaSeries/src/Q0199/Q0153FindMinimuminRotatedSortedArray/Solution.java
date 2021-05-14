package Q0199.Q0153FindMinimuminRotatedSortedArray;

import org.junit.Test;

public class Solution {

    @Test
    public void test1() {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    @Test
    public void test2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }

    @Test
    public void test3() {
        int[] nums = {11, 13, 15, 17};
        System.out.println(findMin(nums));
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) end = mid;
            else start = mid + 1;
        }
        return nums[start];
    }
}
