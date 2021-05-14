package Q0299.Q0229MajorityElementII;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    public void test1() {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == number1) count1++;
            else if (num == number2) count2++;
            else if (count1 == 0) {
                number1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == number1) count1++;
            else if (num == number2) count2++;
        }
        if (count1 > nums.length / 3) result.add(number1);
        if (count2 > nums.length / 3) result.add(number2);
        return result;
    }
}
