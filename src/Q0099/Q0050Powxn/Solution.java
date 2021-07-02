package Q0099.Q0050Powxn;

import org.junit.Test;

import static java.lang.Math.pow;

public class Solution {

    @Test
    public void test1() {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }
}
