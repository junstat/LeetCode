package Q0099.Q0035SearchInsertPosition;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {
    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        assertEquals(searchInsert(nums, target), 2);
    }

    @Test
    public void test2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        assertEquals(searchInsert(nums, target), 1);
    }

    @Test
    public void test3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        assertEquals(searchInsert(nums, target), 4);
    }

    @Test
    public void test4() {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        assertEquals(searchInsert(nums, target), 0);
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;   // low <= mid,  mid < high
            if (nums[mid] >= target) high = mid;  // high always decreases  (even high - low =1)
            else low = mid + 1;   // low always increases
        }
        return low;
    }
}
