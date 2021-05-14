package Q0099.Q0075SortColors;

public class Solution {
    /*
        The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.

It is hard to define what is a "one-pass" solution but this algorithm is bounded by O(2n), meaning that at most each element will be seen and operated twice (in the case of all 0s). You may be able to write an algorithm which goes through the list only once, but each step requires multiple operations, leading the total operations larger than O(2n).
       类似快排思想
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int low = 0, high = nums.length - 1;
        int i = 0;
        while (i <= high) {
            if (nums[i] == 0) {
                exchange(nums, i, low);
                i++;
                low++;
            } else if (nums[i] == 2) {
                exchange(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
