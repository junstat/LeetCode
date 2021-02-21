package Q300.Q229MajorityElementII;

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


class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        } else if (nums.length == 2) {
            if (nums[0] == nums[1]) {
                res.add(nums[0]);
                return res;
            }
            res.add(nums[0]);
            res.add(nums[1]);
            return res;
        }
        quickSort(nums, 0, nums.length - 1, res);

        return res;
    }

    private void quickSort(int[] nums, int start, int end, List<Integer> res) {
        int threshold = nums.length / 3;
        if (end - start + 1 <= threshold) return;

        int pivot = nums[end];
        int pos = start - 1;
        int count = 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, ++pos, i);
            } else if (nums[i] == pivot) {
                swap(nums, pos + count, i);
                count++;
            }

        }

        swap(nums, pos + count, end);
        if (count > threshold) {
            res.add(pivot);
        }

        quickSort(nums, start, pos, res);
        quickSort(nums, pos + count, end, res);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}