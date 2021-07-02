package Q0099.Q0027RemoveElement;

import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int n : nums) {
            if (n != val) nums[i++] = n;
        }
        return i;
    }
}
