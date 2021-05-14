package Q0099.Q0084LargestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    /*
      方法1： 暴力方法
       - 面积 = 底 x 高
       - 固定底，求最大高度不好求
       - 固定高，求最长底边好求
       - 从i向两边遍历，找到左边和右边第1个严格小于height[i]的时候停下，中间的长度就是最长底边
       时间复杂度度: O(n^2)，空间复杂度: O(1)
     */
    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        int ans = 0;
        for (int cur = 0; cur < len; cur++) { // 枚举高
            int height = heights[cur];
            int left = cur, right = cur;
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                --left;
            }
            while (right + 1 < len && heights[right + 1] >= height) {
                ++right;
            }
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }

    /*
       方法2: 空间换时间 (栈)
       特殊情况1: 遍历完成以后
       特殊情况2: 弹出栈顶元素后，栈为空
       特殊情况3: 栈中存在高度相等的元素
      */
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int area = 0;

        // 官方不推荐使用 Stack, 因为 Stack 依赖 Vector(效率低)
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            //   对栈操作的前提，非空            当前元素小于栈顶元素(不单调了)
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];  // 弹栈，保存栈顶高度
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }
                int width;
                if (stack.isEmpty()) width = i;
                else width = i - stack.peekLast();
                area = Math.max(area, height * width);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];  // 弹栈，保存栈顶高度
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }
            int width;
            if (stack.isEmpty()) width = len;
            else width = len - stack.peekLast() - 1;
            area = Math.max(area, height * width);
        }
        return area;
    }

    /*
       在方法2的基础上，加入哨兵
       技巧:
        - 使用"哨兵"(Sentinel)，避免特殊情况的讨论
        - "哨兵"技巧的其它应用: 单链表虚拟头结点、插入排序
        时间复杂度: O(n), 空间复杂度: O(n)
      */
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

/*
   单调栈(Monotone Stack)
    - 单调栈首先是栈，是栈的应用
    - 栈内元素维持了"单调性"的应用场景
      1. 单调递增(不减)栈可以找到左边第一个比当前出栈元素小(包含等于)的元素
      2. 单调递减(不增)栈可以找到左边第一个比当前出栈元素大(包含等于)的元素

   练习:
    42
    739
    496
    316
    901
    402
    581
  */