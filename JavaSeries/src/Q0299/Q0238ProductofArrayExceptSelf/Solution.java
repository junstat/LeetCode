package Q0299.Q0238ProductofArrayExceptSelf;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    @Test
    public void test2() {
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    /*
       res[i] = nums[0] * nums[1] * ... * nums[i-1] * nums[i+1] * ... * nums[n-1]
       分为两部分计算:
       1) nums[0] * nums[1] * ... * nums[i-1]
       2) nums[i+1] * ... * nums[n-1]
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // 1) nums[0] * nums[1] * ... * nums[i-1]
        for (int i = 1; i < n; i++) res[i] = res[i - 1] * nums[i - 1];
        int right = 1;
        // 2) nums[i+1] * ... * nums[n-1]
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
