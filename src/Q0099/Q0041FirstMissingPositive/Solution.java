package Q0099.Q0041FirstMissingPositive;

/*
  Put each number in its right place.
    For example:
    When we find 5, then swap it with A[4].
    At last, the first place where its number is not right, return the place + 1.
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1) return i + 1;

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
