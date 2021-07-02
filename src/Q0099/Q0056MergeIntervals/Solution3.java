package Q0099.Q0056MergeIntervals;

/*
   执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
   内存消耗：40.9 MB, 在所有 Java 提交中击败了88.25%的用户
 */
public class Solution3 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if ((intervals[i][0] <= intervals[j][1]) && (intervals[i][1] >= intervals[j][0])) {
                    if (intervals[i][0] <= intervals[j][0]) {
                        intervals[j][0] = intervals[i][0];
                    }
                    if (intervals[i][1] >= intervals[j][1]) {
                        intervals[j][1] = intervals[i][1];
                    }
                    count++;
                    intervals[i] = null;
                    break;
                }
            }
        }

        int[][] arrInt = new int[intervals.length - count][];
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                arrInt[j++] = intervals[i];
            }
        }
        return arrInt;

    }
}
