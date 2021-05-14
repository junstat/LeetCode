package Q0099.Q0018FourSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    General Idea
        If you have already read and implement the 3sum and 4sum by using the sorting approach: reduce them into 2sum at the end, you might already got the feeling that, all ksum problem can be divided into two problems:

    1> 2sum Problem
    2> Reduce K sum problem to K – 1 sum Problem
    Therefore, the ideas is simple and straightforward. We could use recursive to solve this problem. Time complexity is O(N^(K-1)).

 */
public class Solution {

    @Test
    public void testFourSum() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (k == 2) {  // trivial solution(平凡解)
            int left = start, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    /*
                       do not use Arrays.asList(), because of UnsupportedOperationException
                       https://stackoverflow.com/questions/1624144/unsupportedoperationexception-when-trying-to-remove-from-the-list-returned-by-ar
                     */
                    List<Integer> solution = new ArrayList<>();
                    solution.add(nums[left]);
                    solution.add(nums[right]);
                    res.add(solution);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) left++;    // small
                else right--;  // large
            }
        } else {
            for (int i = start; i < len - (k - 1); i++) {
                // avoid duplicates
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            } // end of for loop
        } // end of else
        return res;
    }
}
