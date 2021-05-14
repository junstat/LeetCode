package Q0099.Q0011ContainerWithMostWater;

public class Solution {
    /**
     * 分析:
     * 问题等价于，有底木桶能装多少水？
     * 双指针: left, right 分别从两边往中间靠近
     * 容积计算:
     * width = right - left;
     * curHeight = min(height[left], height[right]);  短板原则
     * volume = width * curHeight
     * 指针移动原则: 短板原则
     * <p>
     * 时间复杂度: O(n), 空间复杂度: O(1)
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int volume = 0;
        while (left < right) {
            volume = Math.max(volume, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return volume;
    }
}
