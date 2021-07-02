package Q0599.Q0509FibonacciNumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
   Solution 3: Dynamic Programming - Top Down Approach
 */
public class Solution2 {
    int[] resultMemo = new int[31];

    @Test
    public void test() {
        assertEquals(fib(4), 3);
    }

    public int fib(int n) {
        if (n <= 1) return n;
        else if (resultMemo[n] != 0)
            return resultMemo[n];
        else
            return resultMemo[n] = fib(n - 1) + fib(n - 2);
    }
}
