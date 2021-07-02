package Q0099.Q0032LongestValidParentheses;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else maxans = Math.max(maxans, i - stack.peek());
            }
        }
        return maxans;
    }
}
