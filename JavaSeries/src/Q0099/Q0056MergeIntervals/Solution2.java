package Q0099.Q0056MergeIntervals;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        int count = intervals.length;
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] s1 = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] s2 = intervals[j];
                if (s1[0] <= s2[1] && s2[0] <= s1[1]) {     // 两个区间有交集
                    // s1 s2 取并
                    s2[0] = Math.min(s1[0], s2[0]);  // 起点最小
                    s2[1] = Math.max(s1[1], s2[1]);  // 终点最大
                    s1[0] = -1;
                    count--;
                    break;
                }
            }
        }
        int[][] ans = new int[count][];
        int index = 0;
        for (int[] itv : intervals) {
            if (itv[0] >= 0) ans[index++] = itv;
        }
        return ans;
    }
}
