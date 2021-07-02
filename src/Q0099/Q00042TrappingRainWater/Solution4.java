package Q0099.Q00042TrappingRainWater;

import java.util.Deque;
import java.util.LinkedList;

public class Solution4 {
    /*
   方法4: 单调栈
   https://www.yuque.com/zapibeidounai/shlaqk/evghql
  */
    public int trap(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            stack.push(current++);
        }
        return ans;
    }
}
