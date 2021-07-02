package Q0599.Q0509FibonacciNumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
   Solution 1: Iterative
   Time complexity: O(n)
   Space complexity: O(1)
 */
public class Solution {

    @Test
    public void test() {
        assertEquals(fib(4), 3);
    }

    public int fib(int n) {
        if (n <= 1) return n;
        int prev = 0, next = 1;
        while (n-- > 1) {
            int sum = prev + next;
            prev = next;
            next = sum;
        }
        return next;
    }
}
