package Q0099.Q0001TwoSum;

import java.util.HashMap;

/*
    分析:
        破镜重圆法
        1. 遍历nums, 遍历当前元素为nums[i](破镜1), other part(破镜2) = target(圆镜) - nums[i]
        2. 使用HashMap elemIndexMaps保存已遍历过的元素，单个元素结构 nums[i]: i；
        3. 若otherPart in elemIndexMaps，task is done；
        4. 若遍历结束，破镜未能圆，return [-1, -1].
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> elemIndexMaps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherPart = target - nums[i];
            if (elemIndexMaps.containsKey(otherPart)) {
                return new int[]{elemIndexMaps.get(otherPart), i};  // Q: 为何要先返回other part的下标？
            }
            elemIndexMaps.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

// A: 因为elemIndexMaps中的元素按照遍历顺序添加，当前遍历元素定晚于otherPart被遍历，即i > index(otherPart)