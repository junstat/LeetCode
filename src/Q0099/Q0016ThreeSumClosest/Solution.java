package Q0099.Q0016ThreeSumClosest;

import java.util.Arrays;

/*
   Similar to 3 Sum(Question 015), use 3 pointers to point current element, next element and the last element. If the sum is less than target, it means we have to add a larger element so next element move to the next. If the sum is greater, it means we have to add a smaller element so last element move to the second last element. Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum difference so far, then replace result with it, otherwise keep iterating.
   Time: O(
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closet - target)) closet = sum;  // update closet
                if (sum < target) left++; // small
                else if (sum > target) right--; // large
                else return sum;
            }
        }
        return closet;
    }
}
