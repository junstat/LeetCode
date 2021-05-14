package Q0099.Q00042TrappingRainWater;

public class Solution5 {
    /*
    Keep track of the already safe level and the total water so far. In each step, process and discard the lower one
of the leftmost or rightmost elevation.
*/
    public int trap5(int[] height) {
        int l = 0, r = height.length - 1, level = 0, water = 0;
        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            water += level - lower;
        }
        return water;
    }
}
