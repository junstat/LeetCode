package Q0099.Q0053MaximumSubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        // dynamic programming
        int res = nums[0];
        int curSum = 0;
        for (int num : nums) {
            if (curSum > 0) curSum += num;
            else curSum = num;
            res = Math.max(res, curSum);
        }
        return res;
    }
}
