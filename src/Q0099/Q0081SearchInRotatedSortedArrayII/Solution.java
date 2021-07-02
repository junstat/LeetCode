package Q0099.Q0081SearchInRotatedSortedArrayII;

public class Solution {
    /*
       https://www.youtube.com/watch?v=eG27FBcmy1k
       类似 Q033 method 3
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0, high = nums.length - 1, mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] > nums[low]) {
                if (nums[mid] >= target && nums[low] <= target) high = mid;
                else low = mid;
            } else if (nums[mid] < nums[low]) {
                if (nums[mid] <= target && nums[high] >= target) low = mid;
                else high = mid;
            } else { // IMPORTANT: Handle the worst case : 1 1 1 1 0 1 1
                low++;
            }
        }
        return nums[low] == target || nums[high] == target;
    }
}
