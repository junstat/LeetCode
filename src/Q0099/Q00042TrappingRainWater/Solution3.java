package Q0099.Q00042TrappingRainWater;

public class Solution3 {
    /*
   Approach 3: Two Pointers
   We can use two variables to track the max_l and max_r so far.

   Use l, r to track two sides, move l, r based on whether max_l < max_r. if max_l < max_r,
   answer depends on max_l, so we move l. 短板原理
  */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}
