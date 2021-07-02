package Q0099.Q0057InsertInterval;

import java.util.ArrayList;
import java.util.List;

/*
   执行用时：1 ms, 在所有 Java 提交中击败了99.92%的用户
   内存消耗：40.8 MB, 在所有 Java 提交中击败了51.97%的用户
 */
public class Solution2 {
    // 模拟法 O(N) + O(N)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0) return new int[][]{newInterval};

        List<int[]> res = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        int i = 0;

        // 保留左端不受影响的部分
        while (i < len && intervals[i][1] < left) {
            res.add(intervals[i]);
            i++;
        }

        // 合并中间重叠的区间
        while (i < len && intervals[i][0] <= right) {
            left = Math.min(intervals[i][0], left);
            right = Math.max(intervals[i][1], right);
            i++;
        }
        res.add(new int[]{left, right});

        // 保留右端不受影响的部分
        while (i < len) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
    }
}
