package Algorithms4e.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/*
   1.1.20 Write a recursive static method that computes the value of ln(N!)
 */
public class Exercise20 {
    public static void main(String[] args) {
        StdOut.println("ln(5!) = " + lnFactorial(5));
        StdOut.println("Expected: 4.787491742782046");
    }

    private static double lnFactorial(int n) {
        if (n == 1) return 0;
        return Math.log(n) + lnFactorial(n - 1);
    }
}
