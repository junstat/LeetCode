package Q0299.Q0283MoveZeros;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    @Test
    public void test1() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = {0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int notZeroIndex = 0;
        for (int num : nums)
            if (num != 0) nums[notZeroIndex++] = num;
        while (notZeroIndex < nums.length) nums[notZeroIndex++] = 0;
    }
}
