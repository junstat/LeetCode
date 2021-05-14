package Q0099.Q0015ThreeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 方法一: 暴力解法
 * 三重循环, time: O(n^3), space: O(1)
 */
public class Solution {
    /*
       方法二: 固定一个数，另两个数用双指针
       time: O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        // corner case
        if (nums == null || nums.length < 3) return res;
        // sort array
        Arrays.sort(nums);
        // for loop to locate the first num
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1;
            // two pointer in while loop
            while (low < high) {
                if (nums[low] + nums[high] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // move two pointers, don't forget check duplicates
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < -nums[i]) { // small
                    low++;
                } else { // large
                    high--;
                }
            }
        }
        return res;
    }
}
