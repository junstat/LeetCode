package Q0099.Q0020ValidParentheses;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution {

    @Test
    public void test1() {
        var s = "()[]{}";
        assertTrue(isValid(s));
    }

    @Test
    public void test2() {
        var s = "([)]";
        assertFalse(isValid(s));
    }

    public boolean isValid(String s) {
        Deque<Character> brackets = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') brackets.push(c);
            else if (c == ')') {
                if (brackets.isEmpty()) return false;
                else if (brackets.peek() == '(') brackets.pop();
                else return false;
            } else if (c == ']') {
                if (brackets.isEmpty()) return false;
                else if (brackets.peek() == '[') brackets.pop();
                else return false;
            } else if (c == '}') {
                if (brackets.isEmpty()) return false;
                else if (brackets.peek() == '{') brackets.pop();
                else return false;
            }
        }
        return brackets.isEmpty();
    }
}
