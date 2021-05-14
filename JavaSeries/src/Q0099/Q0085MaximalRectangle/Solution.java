package Q0099.Q0085MaximalRectangle;

import java.util.ArrayDeque;
import java.util.Deque;
/*
   以 example 1. 为例
    matrix = [
      ["1","0","1","0","0"],
      ["1","0","1","1","1"],
      ["1","1","1","1","1"],
      ["1","0","0","1","0"]
    ]

    分析: 遍历 行(row)
    row = 1: 可以得到 heights = [1, 0, 1, 0, 0] 套用 Q84
    row = 2: -> heights = [2, 0, 2, 1, 1]
    ......
  */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int max = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < col; j++) {
                if (chars[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }
        return max;
    }

    // 来自 Q84
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int area = 0;
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        len += 2;
        heights = newHeights;

        // 官方不推荐使用 Stack, 因为 Stack 依赖 Vector(效率低)
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            //          当前元素小于栈顶元素(不单调了)
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];  // 弹栈，保存栈顶高度
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            stack.addLast(i);
        }
        return area;
    }
}
