package Q0099.Q0026RemoveDuplicatesFromSortedArray;

import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int uniqueElementIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueElementIndex]) nums[++uniqueElementIndex] = nums[i];
        }
        return uniqueElementIndex + 1;
    }
}
