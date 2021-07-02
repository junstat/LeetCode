package Q0099.Q0034FindFirstAndLastPositionOfElementInSortedArray;

public class Solution2 {
    /*
     A cheating trick.
    */
    public int[] searchRange(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        double left = target - 0.5, right = target + 0.5;
        int l = binarySearch(nums, left), r = binarySearch(nums, right);
        return (l == r) ? new int[]{-1, -1} : new int[]{l, r - 1};
    }

    private int binarySearch(int[] nums, double target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (target > nums[m]) l = m + 1;
            else h = m - 1;
        }
        return l;
    }
}
