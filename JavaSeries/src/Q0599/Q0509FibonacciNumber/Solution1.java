package Q0599.Q0509FibonacciNumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
   Solution 2: Recursive
 */
public class Solution1 {
    @Test
    public void test() {
        assertEquals(fib(4), 3);
    }

    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
