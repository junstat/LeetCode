package Q0299.Q0268MissingNumber;

import org.junit.Test;

public class Solution {

    @Test
    public void test1() {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    @Test
    public void test2() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int res = 0, i = 0;
        for (; i < nums.length; i++) res ^= i ^ nums[i];
        return res ^ i;
    }
}
