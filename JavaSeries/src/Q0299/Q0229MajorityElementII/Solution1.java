package Q0299.Q0229MajorityElementII;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
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
