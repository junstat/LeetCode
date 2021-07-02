package Q0099.Q0084LargestRectangleInHistogram;

/*
   time: 100%
 */
public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length, res = 0, i;
        int[] leftBounds = new int[N + 1], rightBounds = new int[N];
        for (i = 1; i < N; i++) {
            int h = heights[i], l = i - 1;
            while (l >= 0 && h <= heights[l]) {
                if (h < heights[l]) {
                    rightBounds[l] = i - 1;
                    res = Math.max(res, (rightBounds[l] - leftBounds[l] + 1) * heights[l]);
                }
                l = leftBounds[l] - 1;
            }
            leftBounds[i] = l + 1;
        }
        i = N;
        while (i > 0) {
            if (heights[i - 1] > 0) {
                rightBounds[i - 1] = N - 1;
                res = Math.max(res, (rightBounds[i - 1] - leftBounds[i - 1] + 1) * heights[i - 1]);
            }
            i = leftBounds[i - 1];
        }
        return res;
    }
}
