package Q200.Q189RotateArray;

import org.junit.Test;

import java.util.Arrays;

/*
   Approach 1:
   nums = "----->-->"; k =3
   result = "-->----->";

   reverse "----->-->" we can get "<--<-----"
   reverse "<--" we can get "--><-----"
   reverse "<-----" we can get "-->----->"
   this visualization help me figure it out :)
 */
class Solution1 {


    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}

/*
   Approach 2: Brute Force
The simplest approach is to rotate all the elements of the array in k steps by rotating the elements by 1 unit in each step.
 */
public class Solution {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}