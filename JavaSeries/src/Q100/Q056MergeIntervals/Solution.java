package Q100.Q056MergeIntervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Solution {

    @Test
    public void test1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    /*
        The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end with the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping intervals. Once we find a non overlapping interval, we can add the previous "extended" interval and start over.

    Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).

      252 Meeting Rooms
      253 Meeting Rooms II
      435 Non-overlapping Intervals <- very similar, i did it with just 3 lines different
    */
    public int[][] merge1(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

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
