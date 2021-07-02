package Q0599.Q0509FibonacciNumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
   Solution 4: Dynamic Programming - Bottom Up Approach
 */
public class Solution3 {

    @Test
    public void test() {
        assertEquals(fib(4), 3);
    }

    public int fib(int n) {
        if (n <= 1) return n;
        int[] resultMemo = new int[n + 1];
        resultMemo[1] = 1;

        for (int i = 2; i <= n; i++)
            resultMemo[i] = resultMemo[i - 1] + resultMemo[i - 2];
        return resultMemo[n];
    }
}
