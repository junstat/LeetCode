package Q0199.Q0150EvaluateReversePolishNotation;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/*
   method 1: 栈
 */
public class Solution {

    @Test
    public void test1() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        assertEquals(evalRPN(tokens), 9);
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isNumber(token)) stack.push(Integer.parseInt(token));
            else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }

        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
