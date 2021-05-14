package Q0099.Q0016ThreeSumClosest;

import java.util.Arrays;

public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int midTarget = target - nums[i];
            int low = i + 1;
            int high = n - 1;
            while (low + 1 < high) {
                int mid = (low + high) >> 1;
                if (nums[mid] + nums[mid + 1] == midTarget) return target;
                if (nums[mid] + nums[mid + 1] < midTarget) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            midTarget = target - nums[i];
            do {
                int diff = nums[low] + nums[high] - midTarget;
                if (Math.abs(diff) < Math.abs(min)) min = diff;
                if (diff < 0) {
                    high++;
                } else {
                    low--;
                }
            } while (low > i && high < n);
        }
        return target + min;
    }
}
