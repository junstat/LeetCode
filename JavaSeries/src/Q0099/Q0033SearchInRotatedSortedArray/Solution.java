package Q0099.Q0033SearchInRotatedSortedArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {
    @Test
    public void test1() {
        int[] nums = {1};
        int target = 1;
        assertEquals(search(nums, target), 0);
    }

    @Test
    public void test2() {
        int[] nums = {1, 3};
        int target = 3;
        assertEquals(search(nums, target), 1);
    }

    @Test
    public void test3() {
        int[] nums = {1, 3};
        int target = 1;
        assertEquals(search(nums, target), 0);
    }

    @Test
    public void test4() {
        int[] nums = {1, 3};
        int target = 2;
        assertEquals(search(nums, target), -1);
    }


    /*
       method 1:
        step 1: 找到nums中的最小值，即为数组元素的偏移量；
        step 2: 执行普通二分查找，不过每次中点 + 偏移量。
       Time: O(log n), Space: O(1)
     */
    public int search1(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int low = 0, n = nums.length, high = n - 1;
        /*
           Find the index of the smallest value using binary search.
           Loop will terminate since mid < high, and low or hi will shrink by at least 1.
           Proof by contradiction that mid < high: if mid == high, then low == high and loop would have been terminated.
         */
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        // low = high is the index of the smallest value and also the number of places rotated.
        int rotated = low;
        low = 0;
        high = n - 1;
        // The usual binary search and accounting for rotation.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int realMid = (mid + rotated) % n;
            if (nums[realMid] == target) return realMid;
            else if (nums[realMid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /*
       Explanation
        Let's say nums looks like this: [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
        Because it's not fully sorted, we can't do normal binary search. But here comes the trick:
        case 1: If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
        [12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]

        case 2: If target is let's say 7, then we adjust nums to this:
        [-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

        And then we can simply do ordinary binary search.
        Of course we don't actually adjust the whole array but instead adjust only on the fly only the elements we look
         at. And the adjustment is done by comparing both the target and the actual element against nums[0].

        Time: O(log n), Space: O(1)
     */
    public int search2(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        // if (nums.length == 1 && nums[0] == target) return 0;

        int rightEndPoint = 10000 + 1;
        int leftEndPoint = -rightEndPoint;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? leftEndPoint : rightEndPoint;

            if (num == target) return mid;
            else if (num < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /*
       method 3: https://www.youtube.com/watch?v=lWEIIFFflQY
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {  // low 与 high 相邻即退出循环
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[low] < nums[mid]) {
                if (nums[low] <= target && nums[mid] >= target) high = mid;    // nums[low] <= target <= nums[mid]
                else low = mid;
            } else if (nums[mid] < nums[high]) {
                if (nums[high] >= target && nums[mid] <= target) low = mid;   // nums[mid] <= target <= nums[high]
                else high = mid;
            }
        }

        if (nums[low] == target) return low;
        if (nums[high] == target) return high;
        return -1;
    }
}
