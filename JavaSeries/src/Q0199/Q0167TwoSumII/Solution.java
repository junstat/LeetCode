package Q0199.Q0167TwoSumII;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    @Test
    public void test2() {
        int[] nums = {2, 3, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            else if (numbers[left] + numbers[right] > target) right--;
            else left++;
        }
        return new int[]{-1, -1};
    }
}
