package Q0199.Q0189RotateArray;

public class Solution2 {
    /*
   Approach 1:
   nums = "----->-->"; k =3
   result = "-->----->";

   reverse "----->-->" we can get "<--<-----"
   reverse "<--" we can get "--><-----"
   reverse "<-----" we can get "-->----->"
   this visualization help me figure it out :)
 */

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
