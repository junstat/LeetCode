package Q0199.Q0162FindPeakElement;

public class Solution2 {
    /*
      Binary Search: recursion
    */

    // @Test
    // public void test() {
    //     int[] nums = {1, 2, 1, 3, 5, 6, 4};
    //     System.out.println(findPeakElement(nums));
    // }

    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int low, int high) {
        if (low == high) return low;
        else {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] > nums[mid2]) return helper(nums, low, mid1);
            else return helper(nums, mid2, high);
        }
    }
}
